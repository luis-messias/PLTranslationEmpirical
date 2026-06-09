package com.example;
import java.util.List;

class Solution {
    /**
     * Determines whether it is possible to perform an exchange of elements
     * between lst1 and lst2 to make lst1 a list of only even numbers.
     *
     * @param lst1 The list that must become all even.
     * @param lst2 The source list for replacements.
     * @return "YES" if possible, otherwise "NO".
     */
    public String exchange(List<Integer> lst1, List<Integer> lst2) {
        // Count odd numbers in lst1 (these need replacement)
        long cntOdd = lst1.stream().filter(n -> n % 2 != 0).count();

        // Count even numbers in lst2 (these are available replacements)
        long cntEven = lst2.stream().filter(n -> n % 2 == 0).count();

        // If the number of odd elements in lst1 is less than or equal to
        // the number of even elements in lst2, the exchange is possible.
        if (cntOdd <= cntEven) {
            return "YES";
        } else {
            return "NO";
        }
    }
}