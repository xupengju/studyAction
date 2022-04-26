package meione.action.strategy;


import meione.action.ComplexParamDTO;
import meione.action.ExecuteResultDTO;

/**
 * 无动作策略
 *
 * @author Milo on 2022/4/24.
 * @description
 */
public class NullStrategy implements WorkFlowStrategy {
    @Override
    public ExecuteResultDTO execute(ComplexParamDTO complexParamDTO) {
        ExecuteResultDTO executeResultDTO = new ExecuteResultDTO();
        return executeResultDTO;
    }
}