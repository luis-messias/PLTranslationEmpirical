package com.example;
class Solution {
    /**
     * Given a non-empty list of integers lst. add the even elements that are at odd indices.
     *
     * Examples:
     * add([4, 2, 6, 7]) ==> 2
     */
    public int add(java.util.List<Integer> lst) {
        int s = 0;
        for (int i = 1; i < lst.size(); i += 2) {
            if (lst.get(i) % 2 == 0) {
                s += lst.get(i);
            }
        }
        return s;
    }
}