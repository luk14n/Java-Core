package java8.DateTimeAPI;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DurationAndPeriod {
    public static void main(String[] args) {
//DISCOUNT COUPON
        Duration duration = Duration.ofHours(1);
        LocalDateTime couponRealeasedAt = LocalDateTime.of(LocalDate.now()
                , LocalTime.of(10, 0));
        boolean isValid = couponRealeasedAt.plus(duration)
                .isAfter(LocalDateTime.now());
        System.out.println(isValid);





/*        Period period = Period.ofYears(10);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.plus(duration));
        System.out.println(now.plus(period));
        System.out.println(now.plus(period).plus(duration));*/


    }
}
