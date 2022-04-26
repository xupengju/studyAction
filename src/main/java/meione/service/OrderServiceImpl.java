package meione.service;

import lombok.extern.slf4j.Slf4j;
import meione.abs.OrderActionService;
import meione.action.ActionEnum;
import meione.action.ComplexOrderParamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Milo on 2022/4/24.
 * @description
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderActionService orderActionService;

    @Override
    public boolean orderCancel(String orderId) {
        log.info("orderPaySuccess orderId is :{}", orderId);

        // 模拟构建参数
        ComplexOrderParamDTO complexParamDTO = new ComplexOrderParamDTO();
        complexParamDTO.setAmount(new BigDecimal("100"));
        complexParamDTO.setCurrentCode(0);
        complexParamDTO.setOrderId(orderId);

        orderActionService.startAction(complexParamDTO, ActionEnum.MANUALLY_CANCEL);
        return false;
    }

    @Override
    public boolean orderPaySuccess(String orderId) {
        log.info("orderPaySuccess orderId is :{}", orderId);

        // 模拟构建参数
        ComplexOrderParamDTO complexParamDTO = new ComplexOrderParamDTO();
        complexParamDTO.setAmount(new BigDecimal("100"));
        complexParamDTO.setCurrentCode(0);
        complexParamDTO.setOrderId(orderId);

        orderActionService.startAction(complexParamDTO, ActionEnum.PAY_SUCCESS);
        // TODO: 2022/4/25  
        return false;
    }


    @Override
    public boolean refundApply(String orderId) {
        log.info("refundApply orderId is :{}", orderId);

        // 模拟构建参数
        ComplexOrderParamDTO complexParamDTO = new ComplexOrderParamDTO();
        complexParamDTO.setAmount(new BigDecimal("100"));
        complexParamDTO.setCurrentCode(1);
        complexParamDTO.setOrderId(orderId);

        orderActionService.startAction(complexParamDTO, ActionEnum.REFUND_APPLY);
        return false;
    }
}
