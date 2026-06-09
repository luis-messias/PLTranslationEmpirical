package com.example;
public class HumanEval_124 {

    public static boolean validDate(String date) {

        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (date.length() != 10 || !date.contains("-") || !date.contains("-")) return false;

        String[] parts = date.split("-");
        int m = Integer.parseInt(parts[0]);

        int d = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);

        if (!Character.isDigit(m.charAt(0)) || !Character.isDigit(d.charAt(0)) || !Character.isDigit(y.charAt(0))) return false;

        m -= 1; // Adjusting month to be zero-based

        if (m < 1 || m > 12) return false;
        if (d < 1 || d > days[m]) return false;

        return true;

    }

}