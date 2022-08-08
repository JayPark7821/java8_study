package me.jaypark.java8.DateTime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Calendar calendar = new GregorianCalendar();
        java.text.SimpleDateFormat dateFormat = new SimpleDateFormat();

        Date date = new Date();
        long time = date.getTime();
        System.out.println("time = " + time);
        System.out.println("date = " + date);

        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        System.out.println("after3Seconds = " + after3Seconds);
        after3Seconds.setTime(time);
        System.out.println("after3Seconds = " + after3Seconds);
        // mutable 하다
        // 멀티스레드 환경에서 안전하게 쓰기 힘들다!
        // thread safe하지 않다!

        Calendar JayBDay = new GregorianCalendar(1990, 9, 3);
        Calendar JayBDay2 = new GregorianCalendar(1990, Calendar.SEPTEMBER, 3);
        // type safe하지 않다!!!
        System.out.println("JayBDay2 = " + JayBDay2.getTime());
        JayBDay2.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println("JayBDay2 = " + JayBDay2.getTime());


        //================================================= Data/Time Api
        Instant instant = Instant.now();
        System.out.println("instant = " + instant); // 기준시 UTC, GMT
        System.out.println("instant.atZone(ZoneId.of(\"UTC\")) = " + instant.atZone(ZoneId.of("UTC")));

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("zoneId = " + zoneId);
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println("zonedDateTime = " + zonedDateTime);

        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        LocalDateTime bDay = LocalDateTime.of(1990, Month.SEPTEMBER, 3, 0, 0);
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("newInKorea = " + nowInKorea);


        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2022, Month.SEPTEMBER, 3);


        Period period = Period.between(today, thisYearBirthday);
        System.out.println("period.getDays() = " + period.getDays());

        Period until = today.until(thisYearBirthday);
        System.out.println("until.get(ChronoUnit.DAYS) = " + until.get(ChronoUnit.DAYS));


        Instant now2 = Instant.now();
        Instant plus = now2.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now2, plus);
        System.out.println("between = " + between.getSeconds());


        LocalDateTime now3 = LocalDateTime.now();
        System.out.println("now3 = " + now3);
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("now3.format(MMddyyyy) = " + now3.format(MMddyyyy));


        LocalDate parse = LocalDate.parse("07/15/1990", MMddyyyy);
        System.out.println("parse = " + parse);

        Date date2 = new Date();
        Instant instant2 = date.toInstant();
        Date date3 = Date.from(instant2);
    }
}
