package meione.action;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import meione.action.strategy.WorkFlowStrategy;
import meione.util.SpringContextUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Milo on 2022/4/24.
 * @description 状态解析容器
 */
@Data
@Slf4j
public class CombinationContainer {

    /**
     * 目标状态
     */
    private MainOrderStatus targetStatus;

    /***
     * 组合队列
     */
    private List<Combination> combinationList;

    /***
     * 匹配到的组合
     */
    private Combination combination;

    /***
     * 根据当前状态和动作匹配该容器中的动作组合, 如果有完全匹配的组合,则认为满足该容器中的目标状态, 返回true
     *
     * @param currentState
     *            当前状态
     * @param action
     *            所执行的动作
     * @return
     */
    public Combination getCombination(MainOrderStatus currentState, ActionEnum action) {
        for (Combination combination : combinationList) {
            MainOrderStatus combinationState = combination.getCurrentState();
            if (!combinationState.stateEquals(currentState)) {
                continue;
            }
            if (!action.actionEquals(combination.getAction())) {
                continue;
            }
            return combination;
        }
        return null;
    }


    public CombinationContainer addCombination(MainOrderStatus currentState, ActionEnum action,
                                               Class<? extends WorkFlowStrategy> workFlowStrategyClass) {
        this.combinationList.add(new Combination(currentState, action, workFlowStrategyClass));
        return this;
    }

    public ExecuteResultDTO start(ComplexParamDTO complexParamDTO) {

        ExecuteResultDTO executeResultDTO = new ExecuteResultDTO();
        // 更新流程
        try {
            WorkFlowStrategy workFlowStrategy =
                    SpringContextUtil.getContext().getBean(combination.getWorkFlowStrategyClass());
            complexParamDTO.setCombination(combination);
            executeResultDTO = workFlowStrategy.execute(complexParamDTO);
        } catch (Exception e) {
            log.error("", e);
        }
        return executeResultDTO;
    }

    public CombinationContainer(MainOrderStatus targetStatus) {
        this.targetStatus = targetStatus;
        combinationList = new ArrayList<>();
    }

    public CombinationContainer(MainOrderStatus targetStatus, List<Combination> combinationList, Combination combination) {
        this.targetStatus = targetStatus;
        this.combinationList = combinationList;
        this.combination = combination;
    }

    public MainOrderStatus getTargetStatus() {
        return targetStatus;
    }

    public void setTargetStatus(MainOrderStatus targetStatus) {
        this.targetStatus = targetStatus;
    }

    public List<Combination> getCombinationList() {
        return combinationList;
    }

    public void setCombinationList(List<Combination> combinationList) {
        this.combinationList = combinationList;
    }

    public Combination getCombination() {
        return combination;
    }

    public void setCombination(Combination combination) {
        this.combination = combination;
    }

    public static CombinationContainer newContainer(MainOrderStatus targetState) {
        return new CombinationContainer(targetState);
    }

    /***
     * 组合
     */
    @Data
    public static class Combination {

        /***
         * 状态
         */
        private MainOrderStatus currentState;

        /***
         * 动作
         */
        private ActionEnum action;

        /****
         * 流程策略
         */
        private Class<? extends WorkFlowStrategy> workFlowStrategyClass;

        /***
         * 组合 初始化
         *
         * @param currentState
         * @param action
         */
        public Combination(MainOrderStatus currentState, ActionEnum action,
                           Class<? extends WorkFlowStrategy> workFlowStrategyClass) {
            this.currentState = currentState;
            this.action = action;
            this.workFlowStrategyClass = workFlowStrategyClass;
        }
    }
}
