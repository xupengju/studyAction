package meione.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meione.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Milo on 2022/4/24.
 * @description
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    final OrderService orderService;

    @RequestMapping(value = "order/cancel/{orderId}")
    public String cancelOrder(@PathVariable("orderId") String orderId){
        orderService.orderCancel(orderId);
        return "success";
    }

    @RequestMapping(value = "order/pay/{orderId}")
    public String cancelPaySuccess(@PathVariable("orderId") String orderId){
        orderService.orderPaySuccess(orderId);
        return "success";
    }

    @RequestMapping(value = "order/refundApply/{orderId}")
    public String refundApply(@PathVariable("orderId") String orderId){
        orderService.refundApply(orderId);
        return "success";
    }
}
