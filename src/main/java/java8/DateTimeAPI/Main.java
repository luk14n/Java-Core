package java8.DateTimeAPI;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        //date.plusDays(7);Not such option
        System.out.println(date.toInstant());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        System.out.println(simpleDateFormat.format(date));

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        simpleDateFormat1.format(calendar.getTime());
        calendar.add(3,100);
        simpleDateFormat1.format(calendar.getTime());
    }
}
