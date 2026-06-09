package com.example;
public class HumanEval_108 {

    public static int count_nums(Integer[] arr) {

        java.util.function.Function<Integer, Integer> judge = x -> {

            String strX;

            if (x < 0) {
                strX = "-" + Math.abs(x).toString();

            } else {
                strX = x.toString();
            }

            char firstChar = strX.charAt(0);

            int sumOfDigits = 0;
            for (char c : strX.toCharArray()) {

                if (Character.isDigit(c)) {

                    sumOfDigits += Character.getNumericValue(c);
                } else if (!firstChar.equals('-')) { // Ignore the '-' sign

                    break;

                }

            }

            return firstChar.equals('-') ? -sumOfDigits : sumOfDigits > 0 ? 1 : 0;

        };

        int count = 0;
        for (Integer num : arr) {

            if (judge.apply(num).equals(1)) {

                count++;

            }

        }

        return count;

    }


    public static void main(String[] args) {

        System.out.println(count_nums(new Integer[]{}) == 0);

        System.out.println(count_nums(new Integer[]{-1, 11, -11}) == 1);

        System.out.println(count_nums(new Integer[]{1, 1, 2}) == 3);

    }

}