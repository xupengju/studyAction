package meione.action;

import lombok.Data;

/**
 * @author Milo on 2022/4/24.
 * @description
 */
public enum MainOrderStatus {

    WAITPAY(0, "待付款"),
    WAITDELIVER(1, "待收货"),
    RECEIVE(2, "已收货"),
    WAITAPPRAISE(3, "待评价"),
    FINISH(4, "已结束"),
    REFUNDING(5, "退款中"),
    REFUNDED(6, "已退款");

    private Integer code;

    private String message;

    MainOrderStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static MainOrderStatus findByCode(Integer code) {
        MainOrderStatus[] projectStateEnums = MainOrderStatus.values();
        for (MainOrderStatus mainOrderStatus : projectStateEnums) {
            if (mainOrderStatus.getCode().equals(code)) {
                return mainOrderStatus;
            }
        }
        return null;
    }


    public boolean stateEquals(MainOrderStatus projectStateEnum) {
        if (projectStateEnum == null) {
            return false;
        }
        return stateCodeEquals(projectStateEnum.getCode());
    }

    public boolean stateCodeEquals(Integer stateCode) {
        return this.getCode().equals(stateCode);
    }
}
