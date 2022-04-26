package meione.action.strategy;

import meione.action.ComplexParamDTO;
import meione.action.ExecuteResultDTO;
import meione.action.MainOrderStatus;
import org.springframework.stereotype.Service;

/**
 * 手动取消订单
 *
 * @author Milo on 2022/4/24.
 * @description
 */
@Service
public class ManuallyCancelStrategy implements WorkFlowStrategy {
    @Override
    public ExecuteResultDTO execute(ComplexParamDTO complexParamDTO) {

        System.out.println("订单 : " + complexParamDTO.getOrderId() +" 手动取消了");
        System.out.println("订单原code 为" + complexParamDTO.getCurrentCode() + " " + MainOrderStatus.findByCode(complexParamDTO.getCurrentCode()).getMessage());
        System.out.println("订单状态修改为 " + complexParamDTO.getNextCode() + " " + MainOrderStatus.findByCode(complexParamDTO.getNextCode()).getMessage());
        return null;
    }
}
