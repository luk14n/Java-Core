package java8.DateTimeAPI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main1 {
    public static void main(String[] args) {
        // LocalDate is immutable
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);
        System.out.println(currentDate.plusDays(4));
        LocalDate localDate = currentDate.plusYears(4);
        System.out.println(localDate);
        System.out.println(currentDate);
        System.out.println();

        System.out.println(currentDate.format(DateTimeFormatter.ofPattern("dd-yyyy-MM")));
        LocalDateTime localDateTimeNOW = LocalDateTime.now();
        System.out.println();
        System.out.println(localDateTimeNOW);
        LocalTime localTime = localDateTimeNOW.toLocalTime();
        System.out.println();
        System.out.println(localTime);

        System.out.println("//");
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time.toLocalTime());


        LocalDate parsed = LocalDate.parse("2020-10-18");
        System.out.println(parsed);
        System.out.println(parsed.getMonth());
        System.out.println(parsed.getYear());


    }
}
