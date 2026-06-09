package com.example;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HumanEval_124 {
    public static boolean validDate(String date) {
        if (date == null || date.isEmpty()) return false;
        String[] parts = date.split("-");
        if (parts.length != 3) return false;
        int month, day, year;
        try {
            month = Integer.parseInt(parts[0]);
            day = Integer.parseInt(parts[1]);
            year = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            return false;
        }
        if (!(1 <= month && month <= 12)) return false;
        int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (!(1 <= day && day <= daysInMonth[month - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validDate("03-11-2000")); // True
        System.out.println(validDate("15-01-2012")); // False
        System.out.println(validDate("04-0-2040")); // False
        System.out.println(validDate("06-04-2020")); // True
        System.out.println(validDate("06/04/2020")); // False
    }
}