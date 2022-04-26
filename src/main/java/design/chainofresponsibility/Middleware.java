package design.chainofresponsibility;

import java.util.Objects;

/**
 * 基础验证接口
 *
 * @author Milo on 2021/9/2.
 * @description
 */
public abstract class Middleware {
    private Middleware next;

    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(String email, String password);


    protected boolean checkNext(String email, String password) {
        if (Objects.isNull(next)) {
            return true;
        }

        return next.check(email, password);
    }
}
