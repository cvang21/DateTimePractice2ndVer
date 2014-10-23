package jdk8.api;

import java.time.Instant;
import java.time.temporal.Temporal;
import java.time.temporal.ChronoUnit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Demo2 {
    public static void main(String[] args) {
        // Get current date and time
        LocalDateTime date = LocalDateTime.now();
        System.out.println("Current date/time with built-in LocalDateTime class format: " + date);
        
        // Now use new DateTimeFormatter class
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
        String strDate = date.format(format);
        System.out.println("Current date/time with custom format provided by DateTimeFormatter: " + strDate);

        // Just get Dates without time values and calculate payday
        format = DateTimeFormatter.ofPattern("MMM d yyyy");
        LocalDate today = LocalDate.now();
        LocalDate payday1 = today.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate payday2 = today.with(TemporalAdjusters.lastDayOfMonth()).minusDays(2);
        System.out.println("Pretend Payday is at the end of this month: " + payday1.format(format));
        System.out.println("Pretend Payday is at the end of this month, less two days: " + payday2.format(format));
        
        
        // What else can you do? Do some research and share with class. You have one hour!
        
        //Calculates how old you are

        LocalDate birthday = LocalDate.of(1977, Month.OCTOBER, 25);

        Period p = Period.between(birthday, today);
        long p2 = ChronoUnit.DAYS.between(birthday, today);
        System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
                   " months, and " + p.getDays() +
                   " days old. (" + p2 + " days total)");
        
        //Calculates the time difference between two dates
        long gap = 0;
        LocalDateTime previous = LocalDateTime.now();
        LocalDateTime current = LocalDateTime.of(2014,Month.OCTOBER, 22, 18, 59, 23);
        
        if (previous != null) {
        gap = ChronoUnit.MINUTES.between(previous,current);
            System.out.println("The difference is " + gap + " SECS");
        }
        
    }
}
