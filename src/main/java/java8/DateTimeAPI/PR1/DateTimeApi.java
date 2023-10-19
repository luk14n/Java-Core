package java8.DateTimeAPI.PR1;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

//У методі todayDate() поверни поточну дату як String в залежності від запиту.
// Запитом може бути дата цілком або її частина:
//
//FULL — поточна дата цілком: рік, місяць і день у форматі YYYY-MM-DD (значення за умовчанням);
//
//YEAR — поточний рік;
//
//MONTH — назва поточного місяця;
//
//DAY — поточний день місяця.
//
//У будь-якому іншому випадку поверни DateTimeException.
//
//Метод getDate() приймає масив із 3 елементів: year, month та day of the month.
// Поверни LocalDate, створений із цих елементів. Якщо масив містить більше ніж 3 елементи,
// поверни DateTimeException.
//
//Метод addHours() приймає час та кількість годин для додавання. Поверни змінений час.
//
//Метод addMinutes() приймає час та кількість хвилин для додавання. Поверни змінений час.
//
//Метод addSeconds() приймає час та кількість секунд для додавання. Поверни змінений час.
//
//Метод addWeeks() приймає дату та кількість тижнів для додавання. Поверни змінену дату.
//
//Метод beforeOrAfter() приймає випадкову дату someDate. Поверни один із рядків:
//
//"someDate is after currentDate" — якщо someDate знаходиться в майбутньому відносно currentDate;
//"someDate is before currentDate" — якщо someDate знаходиться в минулому відносно currentDate;
//"someDate is today" — якщо someDate сьогодні.
//Метод getDateInSpecificTimeZone() приймає дату та часовий пояс. Поверни LocalDateTime
// у цьому часовому поясі.
//
//Метод offsetDateTime() приймає LocalDateTime. Поверни OffsetDateTime із часовим поясом
// (+02:00 для України).
//
//Наприклад, у тебе є LocalDateTime зі значенням 2019-09-06T13:17. Потрібно повернути
// OffsetDateTime зі значенням 2019-09-06T13:17+02:00, де +02:00 — це часовий пояс.
//
//Тип даних OffsetDateTime рекомендований для зберігання значень дати в базі даних.
//
//Метод parseDate() приймає рядок у форматі yyyymmdd. Поверни дату у вигляді LocalDate,
// побудовану із заданого рядка.
//
//Метод customParseDate() приймає рядок у форматі d MMM yyyy (MMM - Sep, Oct тощо).
// Поверни дату у вигляді LocalDate, побудовану із заданого рядка.
//
//Метод formatDate() приймає LocalDateTime. Поверни рядок у форматі day(2-digit)
// month(full name in English) year(4-digit) hours(24-hour format):minutes. Наприклад,
// "01 January 2000 18:00".
public class DateTimeApi {
    public static void main(String[] args) {
        System.out.println(todayDate(DateTimePart.DAY));
        System.out.println(formatDate(LocalDateTime.now()));
    }

    /**
     * Return the current date as a String depending on a query.
     * <p>
     * The query can be passed for the whole date or for it's part:
     * - FULL - current date as a whole: year, month, day of month
     * formatted as `YYYY-MM-DD` (a default return value);
     * - YEAR - current year;
     * - MONTH - name of the current month;
     * - DAY - current day of month;
     * In any other case throw DateTimeException.
     **/
    public static String todayDate(DateTimePart datePart) {
        LocalDate currentDate = LocalDate.now();
        switch (datePart) {
            case FULL -> {
                return currentDate.toString();
            }
            case YEAR -> {
                return String.valueOf(currentDate.getYear());
            }
            case MONTH -> {
                return String.valueOf(currentDate.getMonth());
            }
            case DAY -> {
                return String.valueOf(currentDate.getDayOfMonth());
            }
            default -> throw new DateTimeException("Oops");
        }
    }

    /**
     * Given an Array of 3 elements, where
     * - 1-st element is a `year`;
     * - 2-nd element is s `month`;
     * - 3-rd element is a `day of month`;
     * <p>
     * Return LocalDate built from these elements. If Array contains more than 3 elements - throw DateTimeException.
     */
    public LocalDate getDate(Integer[] dateParams) {
        if (dateParams.length != 3) {
            throw new DateTimeException("Expected exactly 3 elements in dateParams array");
        } else {
            return LocalDate.of(dateParams[0], dateParams[1], dateParams[2]);
        }
    }

    /**
     * Given the time and the number of hours to add, return the changed time.
     */
    public LocalTime addHours(LocalTime localTime, Integer hoursToAdd) {
        return localTime.plusHours(hoursToAdd);
    }

    /**
     * Given the time and the number of minutes to add, return the changed time.
     */
    public LocalTime addMinutes(LocalTime localTime, Integer minutesToAdd) {
        return localTime.plusMinutes(minutesToAdd);
    }

    /**
     * Given the time and the number of seconds to add, return the changed time.
     */
    public LocalTime addSeconds(LocalTime localTime, Integer secondsToAdd) {
        return localTime.plusSeconds(secondsToAdd);
    }

    /**
     * Given the date and the number of weeks to add, return the changed date.
     */
    public LocalDate addWeeks(LocalDate localDate, Integer numberOfWeeks) {
        return localDate.plusWeeks(numberOfWeeks);
    }

    /**
     * Given a random `someDate` date, return one of the following Strings:
     * - "`someDate` is after `currentDate`"
     * if `someDate` is in the future relating to the `current date`;
     * - "`someDate` is before `currentDate`"
     * if `someDate` is in the past relating to the `current date`;
     * - "`someDate` is today"
     * if `someDate` is today;
     */
    public String beforeOrAfter(LocalDate someDate) {
        LocalDate currentDate = LocalDate.now();
        if (someDate.isAfter(currentDate)) {
            return someDate + " is after " + currentDate;
        } else if (someDate.isBefore(currentDate)) {
            return someDate + " is before " + currentDate;
        } else if (someDate.equals(currentDate)) {
            return someDate + " is today";
        }
        throw new DateTimeException("Oops");
    }

    /**
     * Given a String representation of a date and some timezone,
     * return LocalDateTime in this timezone.
     */
    public LocalDateTime getDateInSpecificTimeZone(String dateInString, String zone) {
        // Define a DateTimeFormatter based on the ISO 8601 date-time format.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");

        // Parse the input date string into a ZonedDateTime using the provided timezone.
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateInString, formatter)
                .withZoneSameInstant(ZoneId.of(zone));

        // Convert the ZonedDateTime to a LocalDateTime.
        return zonedDateTime.toLocalDateTime();
    }

    /**
     * Given some LocalDateTime, return an OffsetDateTime with the local time offset applied
     * (`+02:00` for Ukraine).
     * <p>
     * Example: we receive a LocalDateTime with a value `2019-09-06T13:17`.
     * We should return the OffsetDateTime with a value `2019-09-06T13:17+02:00`,
     * where `+02:00` is the offset for our local timezone.
     * <p>
     * OffsetDateTime is recommended to use for storing date values in a database.
     */
    public OffsetDateTime offsetDateTime(LocalDateTime localTime) {
        return OffsetDateTime.of(localTime, ZoneOffset.of("+02:00"));
    }

    /**
     * Given a String formatted as `yyyyMMdd`,
     * return LocalDate object built from this String.
     */
    public LocalDate parseDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(date, dateTimeFormatter);
    }

    /**
     * Given a String formatted as `d MMM yyyy` (MMM - Sep, Oct, etc.),
     * return LocalDate object built from this String.
     */
    public LocalDate customParseDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);
        return LocalDate.parse(date, dateTimeFormatter);
    }

    /**
     * Given some LocalDateTime, return a String formatted as
     * `day(2-digit) month(full name in English) year(4-digit) hours(24-hour format):minutes`.
     * <p>
     * Example: "01 January 2000 18:00".
     */
    public static String formatDate(LocalDateTime dateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM uuuu HH:mm", Locale.ENGLISH);
        return dateTime.format(dateTimeFormatter);
    }
}
