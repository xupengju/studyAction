package meione.action.strategy;


import meione.action.ComplexParamDTO;
import meione.action.ExecuteResultDTO;

/**
 * @author Milo on 2022/4/24.
 * @description
 */
public interface WorkFlowStrategy {
    /**
     * 执行策略
     *
     * @param complexParamDTO
     * @return
     */
    ExecuteResultDTO execute(ComplexParamDTO complexParamDTO);
}
