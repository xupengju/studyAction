package j8;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class RentPeriodVO {
    private String rentPeriodY;
    private String rentPeriodM;

    private String rentStartDate;
    private String rentEndDate;

    @Override
    public String toString() {
        return "RentPeriodVO{" +
                "rentPeriodY='" + rentPeriodY + '\'' +
                ", rentPeriodM='" + rentPeriodM + '\'' +
                ", rentStartDate='" + rentStartDate + '\'' +
                ", rentEndDate='" + rentEndDate + '\'' +
                '}';
    }

    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public void setRentPeriodYM(String rentStartDate, String rentEndDate) {

        if (StringUtils.isBlank(rentStartDate) || StringUtils.isBlank(rentEndDate)) {
            this.rentStartDate = "0";
            this.rentEndDate = "0";
            return;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime start = dateTimeFormatter.parseDateTime(rentStartDate);
        DateTime end = dateTimeFormatter.parseDateTime(rentEndDate);
        int months = Months.monthsBetween(start, end).getMonths();

        this.rentPeriodY = String.valueOf((int)months / 12);
        this.rentPeriodM = String.valueOf(months - Integer.parseInt(rentPeriodY) * 12);

    }

    public static void main(String[] args) {
        RentPeriodVO rentPeriodVO = new RentPeriodVO();
        rentPeriodVO.setRentPeriodYM("2019-01-13 00:00:00","2021-01-13 00:00:00");
        System.out.println(rentPeriodVO.toString());
    }

}