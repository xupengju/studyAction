package joda;

import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * @author Milo on 2022/1/11.
 * @description
 */
public class TestTime {
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_START = "yyyy-MM-dd 00:00:00";
    public static final String DATE_FORMAT_END = "yyyy-MM-dd 23:59:59";
    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final  DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(DATE_FORMAT_START);

    public static void main(String[] args) {
        DateTime dateTime = new DateTime();
        String timeStart = dateTime.toString(DATE_FORMAT_START);
        String timeEnd = dateTime.toString(DATE_FORMAT_END);
        System.out.println(timeStart);
        System.out.println(timeEnd);

//        System.out.println(new DateTime(timeStart).isAfter(new DateTime(timeEnd)));
//        System.out.println(new DateTime(timeStart).isBefore(new DateTime(timeEnd)));
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime1 = dateTimeFormatter.parseDateTime(timeStart);
        DateTime dateTime2 = dateTimeFormatter.parseDateTime(timeEnd);

        System.out.println(new DateTime(dateTime1).isAfter(new DateTime(dateTime2)));
        System.out.println(new DateTime(dateTime1).isBefore(new DateTime(dateTime2)));

        int i = Minutes.minutesBetween(dateTime1, dateTime2).getMinutes();
        int z = Hours.hoursBetween(dateTime1, dateTime2).getHours() * 60;

        System.out.println(i);
        System.out.println(z);

    }
}
