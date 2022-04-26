package meione.action;

import meione.action.strategy.*;

/**
 * 当前状态 + 动作 = 次态
 *
 * @author Milo on 2022/4/24.
 * @description 状态流转
 */
public enum StateMachine {

    // 待发货
    WAITDELIVER(CombinationContainer.newContainer(MainOrderStatus.WAITDELIVER)
                                    .addCombination(MainOrderStatus.WAITPAY, ActionEnum.PAY_SUCCESS, PaySuccessStrategy.class)),

    // 已结束
    FINISH(CombinationContainer.newContainer(MainOrderStatus.FINISH)
                               .addCombination(MainOrderStatus.WAITAPPRAISE, ActionEnum.SUBMIT_EVALUATION, NullStrategy.class)
                               .addCombination(MainOrderStatus.WAITPAY, ActionEnum.MANUALLY_CANCEL, ManuallyCancelStrategy.class)
                               .addCombination(MainOrderStatus.WAITPAY, ActionEnum.AUTO_CANCEL, NullStrategy.class)),

    // 退款中
    REFUNDING(CombinationContainer.newContainer(MainOrderStatus.REFUNDING)
                                  .addCombination(MainOrderStatus.WAITDELIVER,ActionEnum.REFUND_APPLY, RefundAuditStrategy.class)
                                  .addCombination(MainOrderStatus.WAITAPPRAISE, ActionEnum.REFUND_APPLY,RefundAuditStrategy.class)),

    // 退款成功
    REFUNDED(CombinationContainer.newContainer(MainOrderStatus.REFUNDED)
                                  .addCombination(MainOrderStatus.REFUNDING,ActionEnum.REFUND_PAID, RefundPaidStrategy.class));



    private CombinationContainer combinationContainer;

    StateMachine(CombinationContainer combinationContainer) {
        this.combinationContainer = combinationContainer;
    }

    public CombinationContainer getCombinationContainer() {
        return combinationContainer;
    }
}
