package com.example;
class Solution {
    public boolean validDate(String date) {
        if (date == null || date.length() != 10) {
            return false;
        }

        if (date.charAt(2) != '-' || date.charAt(5) != '-') {
            return false;
        }

        String mStr = date.substring(0, 2);
        String dStr = date.substring(3, 5);
        String yStr = date.substring(6, 10);

        // Check if all parts are digits
        if (!mStr.matches("\\d{2}") || !dStr.matches("\\d{2}") || !yStr.matches("\\d{4}")) {
            return false;
        }

        int m;
        int d;
        int y;
        try {
            m = Integer.parseInt(mStr);
            d = Integer.parseInt(dStr);
            y = Integer.parseInt(yStr);
        } catch (NumberFormatException e) {
            return false;
        }

        // Month validation
        if (m < 1 || m > 12) {
            return false;
        }

        // Day validation (Using the hardcoded logic from the Python source)
        // Index 0 = Jan, Index 1 = Feb, ..., Index 11 = Dec
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (d < 1 || d > days[m - 1]) {
            return false;
        }

        return true;
    }
}