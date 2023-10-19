package java8.DateTimeAPI.PR1;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

public class DateTimeApiTest {
  private static final LocalDateTime LOCAL_DATE_TIME =
    LocalDateTime.of(2000, 12, 31, 23, 59, 59);
  private DateTimeApi dateTimeApi = new DateTimeApi();

  @Test
  public void todayDate_FullOk() {
    String expected = String.valueOf(LocalDate.now());
    String result = dateTimeApi.todayDate(DateTimePart.FULL);
    Assert.assertEquals("Today date must be: " + expected
      + "\nbut was: " + result + "\n", expected, result);
  }

  @Test
  public void todayDate_YearOk() {
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int year = calendar.get(Calendar.YEAR);
    String expected = String.valueOf(year);
    String result = dateTimeApi.todayDate(DateTimePart.YEAR);
    Assert.assertEquals("Today date must be: " + expected
      + "\nbut was: " + result + "\n", expected, result);
  }

  @Test
  public void todayDate_MonthOk() {
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int monthIndex = calendar.get(Calendar.MONTH);
    String expected = Month.of(monthIndex + 1).toString();
    String result = dateTimeApi.todayDate(DateTimePart.MONTH);
    Assert.assertEquals("Today date must be: " + expected
      + "\nbut was: " + result + "\n", expected, result);
  }

  @Test
  public void todayDate_DayOk() {
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int numberOfDay = calendar.get(Calendar.DAY_OF_MONTH);
    String expected = String.valueOf(numberOfDay);
    String result = dateTimeApi.todayDate(DateTimePart.DAY);
    Assert.assertEquals("Today date must be: " + expected
      + "\nbut was: " + result + "\n", expected, result);
  }

  @Test(expected = DateTimeException.class)
  public void todayDate_ThrowException() {
    dateTimeApi.todayDate(DateTimePart.SECONDS);
    dateTimeApi.todayDate(DateTimePart.MINUTES);
  }

  @Test
  public void getDate_Ok() {
    Integer[] dateParams = {2018, 12, 21};
    LocalDate expected = LocalDate.of(2018, 12, 21);
    LocalDate result = dateTimeApi.getDate(dateParams);
    Assert.assertEquals("getData with params: " + Arrays.toString(dateParams)
      + "\nmust be: " + expected + "\n", expected, result);
    Integer[] secondDateParams = {2019, 9, 6};
    expected = LocalDate.of(2019, 9, 6);
    result = dateTimeApi.getDate(secondDateParams);
    Assert.assertEquals("getData with params: " + Arrays.toString(secondDateParams)
      + "\nmust be: " + expected + "\n", expected, result);
  }

  @Test(expected = DateTimeException.class)
  public void getDate_EmptyOk() {
    Integer[] dateParams = {};
    dateTimeApi.getDate(dateParams);
  }

  @Test
  public void addHours_Ok() {
    LocalTime expected = LocalTime.of(3, 59, 59);
    LocalTime result = dateTimeApi.addHours(LOCAL_DATE_TIME.toLocalTime(), 268);
    Assert.assertEquals("Result of addHours with time " + LOCAL_DATE_TIME.toLocalTime()
      + " and hoursToAdd 268 must be " + expected + "\n", expected, result);
    expected = LocalTime.of(17, 59, 59);
    result = dateTimeApi.addHours(LOCAL_DATE_TIME.toLocalTime(), 354);
    Assert.assertEquals("Result of addHours with time " + LOCAL_DATE_TIME.toLocalTime()
      + " and hoursToAdd 354 must be " + expected + "\n", expected, result);
  }

  @Test
  public void addMinutes_Ok() {
    LocalTime expected = LocalTime.of(9, 48, 59);
    LocalTime result = dateTimeApi.addMinutes(LOCAL_DATE_TIME.toLocalTime(), 589);
    Assert.assertEquals("Result of addMinutes with time " + LOCAL_DATE_TIME.toLocalTime()
      + " and minutesToAdd 589 must be " + expected + "\n", expected, result);
    expected = LocalTime.of(5, 52, 59);
    result = dateTimeApi.addMinutes(LOCAL_DATE_TIME.toLocalTime(), 353);
    Assert.assertEquals("Result of addMinutes with time " + LOCAL_DATE_TIME.toLocalTime()
      + " and minutesToAdd 353 must be " + expected + "\n", expected, result);
  }

  @Test
  public void addSeconds_Ok() {
    LocalTime expected = LocalTime.of(6, 39, 48);
    LocalTime result = dateTimeApi.addSeconds(LOCAL_DATE_TIME.toLocalTime(), 369589);
    Assert.assertEquals("Result of addSeconds with time " + LOCAL_DATE_TIME.toLocalTime()
      + " and secondsToAdd 369589 must be " + expected + "\n", expected, result);
    expected = LocalTime.of(17, 9, 14);
    result = dateTimeApi.addSeconds(LOCAL_DATE_TIME.toLocalTime(), 234555);
    Assert.assertEquals("Result of addSeconds with time " + LOCAL_DATE_TIME.toLocalTime()
      + " and secondsToAdd 234555 must be " + expected + "\n", expected, result);
  }

  @Test
  public void addWeeks_Ok() {
    LocalDate expected = LocalDate.of(2001, 1, 14);
    LocalDate result = dateTimeApi.addWeeks(LOCAL_DATE_TIME.toLocalDate(), 2);
    Assert.assertEquals("Result of addWeeks with date " + LOCAL_DATE_TIME.toLocalDate()
      + " and weeksToAdd 2 must be " + expected + "\n", expected, result);
    expected = LocalDate.of(2001, 1, 28);
    result = dateTimeApi.addWeeks(LOCAL_DATE_TIME.toLocalDate(), 4);
    Assert.assertEquals("Result of addWeeks with date " + LOCAL_DATE_TIME.toLocalDate()
      + " and weeksToAdd 4 must be " + expected + "\n", expected, result);
  }

  @Test
  public void beforeDate_Ok() {
    LocalDate someDate = LocalDate.of(2019, 9, 3);
    String expected = someDate + " is before " + LocalDate.now();
    String result = dateTimeApi.beforeOrAfter(someDate);
    Assert.assertEquals("Expected: " + expected + "\nbut was: " + result + "\n", expected, result);
  }

  @Test
  public void afterDate_Ok() {
    LocalDate someDate = LocalDate.now().plusMonths(2);
    String expected = someDate + " is after " + LocalDate.now();
    String result = dateTimeApi.beforeOrAfter(someDate);
    Assert.assertEquals("Expected: " + expected + "\nbut was: " + result + "\n", expected, result);
  }

  @Test
  public void nowDate_Ok() {
    LocalDate someDate = LocalDate.now();
    String expected = someDate + " is today";
    String result = dateTimeApi.beforeOrAfter(someDate);
    Assert.assertEquals("Expected: " + expected + "\nbut was: " + result + "\n", expected, result);
  }

  @Test
  public void getDateInSpecificTimeZone_Ok() {
    LocalDateTime expectedResult1 = LocalDateTime.parse("2020-04-17T00:23:01");
    LocalDateTime actualResult1 = dateTimeApi
      .getDateInSpecificTimeZone("2020-04-16T15:23:01Z", "Asia/Tokyo");
    Assert.assertEquals("DateTime 2020-04-16T15:23:01Z in timezone Asia/Tokyo must be "
      + expectedResult1 + "\n", expectedResult1, actualResult1);

    LocalDateTime expectedResult2 = LocalDateTime.parse("2020-04-16T18:23:01");
    LocalDateTime actualResult2 = dateTimeApi
      .getDateInSpecificTimeZone("2020-04-16T15:23:01Z", "Europe/Athens");
    Assert.assertEquals("DateTime 2020-04-16T15:23:01Z in timezone Europe/Athens must be "
      + expectedResult2 + "\n", expectedResult2, actualResult2);
  }

  @Test
  public void offsetDateTime_UkraineOk() {
    LocalDateTime localDateTime =
      LocalDateTime.of(2019, Month.SEPTEMBER, 6, 13, 17);
    OffsetDateTime expected = OffsetDateTime.of(localDateTime, ZoneOffset.of("+02:00"));
    OffsetDateTime result = dateTimeApi.offsetDateTime(localDateTime);
    Assert.assertEquals("LocalDateTime " + localDateTime
      + " in Ukrainian timezone must be " + expected + "\n", expected, result);
    localDateTime = LocalDateTime.of(2020, Month.JULY, 15, 12, 24);
    expected = OffsetDateTime.of(localDateTime, ZoneOffset.of("+02:00"));
    result = dateTimeApi.offsetDateTime(localDateTime);
    Assert.assertEquals("LocalDateTime " + localDateTime
      + " in Ukrainian timezone must be " + expected + "\n", expected, result);
  }

  @Test
  public void parseDate_Ok() {
    LocalDate expected = LocalDate.of(2019, 9, 21);
    LocalDate result = dateTimeApi.parseDate("20190921");
    Assert.assertEquals("Method parseDate must return " + expected
      + " for input 20190921\n", expected, result);
    expected = LocalDate.of(2020, 3, 17);
    result = dateTimeApi.parseDate("20200317");
    Assert.assertEquals("Method parseDate must return " + expected
      + " for input 20200317\n", expected, result);
  }

  @Test
  public void customParseDate_Ok() {
    LocalDate expected = LocalDate.of(2019, 9, 6);
    LocalDate result = dateTimeApi.customParseDate("06 Sep 2019");
    Assert.assertEquals("Method customParseDate must return " + expected
      + " for input 06 Sep 2019\n", expected, result);
    expected = LocalDate.of(2021, 6, 9);
    result = dateTimeApi.customParseDate("09 Jun 2021");
    Assert.assertEquals("Method customParseDate must return " + expected
      + " for input 09 Jun 2021\n", expected, result);
  }

  @Test
  public void formatDate_Ok() {
    String expected = "06 September 2019 16:15";
    LocalDateTime localDateTime = LocalDateTime.of(2019, 9, 6, 16, 15, 26);
    String result = dateTimeApi.formatDate(localDateTime);
    Assert.assertEquals("LocalDateTime must be formatted as: " + expected
      + "\nbut was: " + result + "\n", expected, result);
    expected = "09 June 2021 17:23";
    localDateTime = LocalDateTime.of(2021, 6, 9, 17, 23, 30);
    result = dateTimeApi.formatDate(localDateTime);
    Assert.assertEquals("LocalDateTime must be formatted as: " + expected
      + "\nbut was: " + result + "\n", expected, result);
  }
}
