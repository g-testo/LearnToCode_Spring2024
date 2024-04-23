package com.ps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
//        DateTimeFormatter formatterOne = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//        DateTimeFormatter formatterTwo = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        DateTimeFormatter formatterThree = DateTimeFormatter.ofPattern("MMMM d, yyyy");
//        LocalDate nowLocalDate = LocalDate.now();
//        System.out.println(nowLocalDate.format(formatterThree));

        LocalDateTime nowLocalDateTime = LocalDateTime.now(ZoneId.of("GMT"));
        DateTimeFormatter formatterFour = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy  HH:mm");

        System.out.println(nowLocalDateTime.format(formatterFour));
    }
}