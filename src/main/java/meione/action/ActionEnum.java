package meione.action;

/**
 * @author Milo on 2022/4/24.
 * @description
 */
public enum ActionEnum {

    MANUALLY_CANCEL(100, "手动取消"),
    AUTO_CANCEL(200, "自动取消"),
    PAY_SUCCESS(300, "支付成功"),
    PAY_FAILD(400, "支付失败"),
    SUBMIT_EVALUATION(500, "提交评价"),
    REFUND_APPLY(600, "退款申请"),
    REFUND_PAID(700, "退款打款");


    private Integer code;

    private String desc;

    ActionEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean actionEquals(ActionEnum actionEnum) {
        return actionEqualsCode(actionEnum.getCode());
    }

    public boolean actionEqualsCode(Integer actionCode) {
        return this.getCode().equals(actionCode);
    }
}
