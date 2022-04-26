package j8.optional;

import com.sun.tools.corba.se.idl.constExpr.Or;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.applet.Main;

import java.util.Optional;

/**
 * @author Milo on 2022/3/15.
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Optional<Order> orderOptional = getOrder();

        System.out.println(orderOptional.orElse(print(new Order())));
        System.out.println(orderOptional.orElseGet(()->print(new Order())));
    }

    private static Order print(Order order) {
        System.out.println("print");
        order = new Order() ;
        return order;
    }

    private static Optional<Order> getOrder() {
        return Optional.of(new Order());
    }


}

@Data
@NoArgsConstructor
class Order{
    String orderNo;
    String userId;
}