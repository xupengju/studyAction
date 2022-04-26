package meione.action.strategy;

import meione.action.ComplexParamDTO;
import meione.action.ExecuteResultDTO;
import org.springframework.stereotype.Service;

/**
 * @author Milo on 2022/4/25.
 * @description
 */
@Service
public class RefundPaidStrategy implements WorkFlowStrategy{
    @Override
    public ExecuteResultDTO execute(ComplexParamDTO complexParamDTO) {
        System.out.println("退款成功");
        System.out.println("订单状态修改");
        System.out.println("ERP 相关");
        System.out.println("记录日志");
        return null;
    }
}
