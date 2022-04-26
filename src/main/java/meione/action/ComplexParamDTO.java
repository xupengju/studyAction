package meione.action;

/**
 * 上下文
 *
 * @author Milo on 2022/4/24.
 * @description
 */
public abstract class ComplexParamDTO {

    private String orderId;

    private Integer currentCode;

    private Integer nextCode;

    /***
     * 匹配到的组合
     */
    private CombinationContainer.Combination combination;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getCurrentCode() {
        return currentCode;
    }

    public void setCurrentCode(Integer currentCode) {
        this.currentCode = currentCode;
    }

    public Integer getNextCode() {
        return nextCode;
    }

    public void setNextCode(Integer nextCode) {
        this.nextCode = nextCode;
    }

    public CombinationContainer.Combination getCombination() {
        return combination;
    }

    public void setCombination(CombinationContainer.Combination combination) {
        this.combination = combination;
    }
}
