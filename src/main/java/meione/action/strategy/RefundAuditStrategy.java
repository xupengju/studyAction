package meione.action.strategy;

import meione.action.ComplexParamDTO;
import meione.action.ExecuteResultDTO;
import meione.action.MainOrderStatus;
import org.springframework.stereotype.Service;

/**
 * @author Milo on 2022/4/25.
 * @description
 */
@Service
public class RefundAuditStrategy implements WorkFlowStrategy{
    @Override
    public ExecuteResultDTO execute(ComplexParamDTO complexParamDTO) {
        System.out.println("退款申请审核");
        System.out.println("记录日志");
        System.out.println("订单原code 为" + complexParamDTO.getCurrentCode() + " " + MainOrderStatus.findByCode(complexParamDTO.getCurrentCode()).getMessage());
        System.out.println("订单状态修改为 " + complexParamDTO.getNextCode() + " " + MainOrderStatus.findByCode(complexParamDTO.getNextCode()).getMessage());
        return null;
    }
}
