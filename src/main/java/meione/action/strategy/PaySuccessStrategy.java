package meione.action.strategy;

import meione.action.ComplexOrderParamDTO;
import meione.action.ComplexParamDTO;
import meione.action.ExecuteResultDTO;
import meione.action.MainOrderStatus;
import meione.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Milo on 2022/4/24.
 * @description 支付成功流程
 */
@Service
public class PaySuccessStrategy implements WorkFlowStrategy {
    @Autowired
    private OrderService orderService;

    @Override
    public ExecuteResultDTO execute(ComplexParamDTO complexParamDTO) {
        ComplexOrderParamDTO complexOrderParamDTO = (ComplexOrderParamDTO) complexParamDTO;
        System.out.println("订单 ID:" + complexOrderParamDTO.getOrderId() + " 付款成功 收款 " + complexOrderParamDTO.getAmount());
        System.out.println("库存确认");
        System.out.println("订单原code 为" + complexParamDTO.getCurrentCode() + " " + MainOrderStatus.findByCode(complexParamDTO.getCurrentCode()).getMessage());
        System.out.println("订单状态修改为 " + complexParamDTO.getNextCode() + " " + MainOrderStatus.findByCode(complexParamDTO.getNextCode()).getMessage());
        System.out.println("订单推送 ERP");
        System.out.println("销量增加");
        System.out.println("销售记录保存");
        System.out.println("日志");

        return null;
    }
}
