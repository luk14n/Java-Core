package java8.DateTimeAPI;

import java.time.*;

public class Zones {
    public static void main(String[] args) {
/*        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        TimeZone aDefault = TimeZone.getDefault();
        System.out.println(aDefault.getDisplayName());

        ZoneId zoneId = aDefault.toZoneId();
        System.out.println(zoneId);*/


        // GET TIME IN SIDNEY
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        ZonedDateTime japan = ZonedDateTime.of(LocalDateTime.now()
                , ZoneId.of(ZoneId.SHORT_IDS.get("JST")));
        System.out.println(japan);

        ZoneId zoneIdfJapan = ZoneId.of(ZoneId.SHORT_IDS.get("JST"));
        ZoneOffset zoneOffset = zoneIdfJapan.getRules().getOffset(LocalDateTime.now());
        System.out.println(zoneOffset);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(), zoneOffset);
        System.out.println(localDateTime);

    }
}
