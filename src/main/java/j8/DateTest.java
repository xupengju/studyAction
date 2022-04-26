package j8;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Milo on 2021/8/27.
 * @description
 */
public class DateTest {
    public static void main(String[] args) {
        Rent rent = new Rent();
        rent.setStartDate("2021-08-27 16:59:49");

        String jsonstr = JSONObject.toJSONString(rent);

        RentLong rentLong = JSONObject.parseObject(jsonstr, RentLong.class);

        System.out.println(rentLong.toString());

    }
}


class Rent{
    private String startDate;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}


class RentLong{
    private Long startDate;

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "RentLong{" +
                "startDate=" + startDate +
                '}';
    }
}