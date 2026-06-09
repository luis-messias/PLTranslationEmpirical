package com.example;
public class HumanEval_124 {
    public static boolean validDate(String date) {
        // Rule 1: The date string is not empty. (Implicitly handled by length check below)
        if (date == null || date.length() != 10) {
            return false;
        }

        // Rule 4: The date should be in the format: mm-dd-yyyy
        if (date.charAt(2) != '-' || date.charAt(5) != '-') {
            return false;
        }

        try {
            String mStr = date.substring(0, 2);
            String dStr = date.substring(3, 5);
            String yStr = date.substring(6, 10);

            // Check if parts are digits (Rule 4 implicitly requires this for parsing)
            if (!mStr.matches("\\d{2}") || !dStr.matches("\\d{2}") || !yStr.matches("\\d{4}")) {
                return false;
            }

            int m = Integer.parseInt(mStr);
            int d = Integer.parseInt(dStr);
            // int y = Integer.parseInt(yStr); // Year is not validated in the Python logic

            // Rule 3: The months should not be less than 1 or higher than 12.
            if (m < 1 || m > 12) {
                return false;
            }

            // Define days in each month (Python logic: [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31])
            int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            // Rule 2: Check day validity
            // The number of days is not less than 1 or higher than the maximum days for that month.
            if (d < 1) {
                return false;
            }
            
            // Check if day is within the valid range for the given month
            // m-1 is the correct index for the array
            if (d > daysInMonth[m - 1]) {
                return false;
            }

            return true;

        } catch (NumberFormatException e) {
            // Should not happen if regex checks pass, but good practice
            return false;
        }
    }
}