package meione.abs;

import meione.action.*;
import org.springframework.stereotype.Service;

/**
 * @author Milo on 2022/4/24.
 * @description
 */
@Service
public class OrderActionService {


    public CombinationContainer combinationContainer = StateMachine.FINISH.getCombinationContainer();


    public void startAction(ComplexParamDTO complexParamDTO, ActionEnum action) {
        MainOrderStatus currentState = MainOrderStatus.findByCode(complexParamDTO.getCurrentCode());
        StateMachine[] actionAnalysisEnums = StateMachine.values();
        CombinationContainer.Combination combination = null;
        for (StateMachine stateMachine : actionAnalysisEnums) {
            combinationContainer = stateMachine.getCombinationContainer();
            combination = combinationContainer.getCombination(currentState, action);
            if (combination != null) {
                combinationContainer.setCombination(combination);
                complexParamDTO.setNextCode(combinationContainer.getTargetStatus().getCode());
                break;
            }

        }

        combinationContainer.start(complexParamDTO);
        // TODO: 2022/4/24 无匹配组合
    }
}
