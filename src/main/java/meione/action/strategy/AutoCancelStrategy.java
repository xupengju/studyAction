package meione.action.strategy;

import meione.action.ComplexParamDTO;
import meione.action.ExecuteResultDTO;
import org.springframework.stereotype.Service;

/**
 * 自动取消订单
 *
 * @author Milo on 2022/4/24.
 * @description
 */
@Service
public class AutoCancelStrategy implements WorkFlowStrategy {
    @Override
    public ExecuteResultDTO execute(ComplexParamDTO complexParamDTO) {
        System.out.println("订单 : " + complexParamDTO.getOrderId() + " 超时自动取消了");
        return null;
    }
}
