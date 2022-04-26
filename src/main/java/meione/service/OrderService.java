package meione.service;

import org.springframework.stereotype.Service;

/**
 * @author Milo on 2022/4/24.
 * @description
 */
public interface OrderService {
    boolean orderCancel(String orderId);

    boolean orderPaySuccess(String orderId);

    boolean refundApply(String orderId);
}
