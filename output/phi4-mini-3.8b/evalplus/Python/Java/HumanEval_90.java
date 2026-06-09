package com.example;
public class HumanEval_90 {

    public static Integer nextSmallest(List<Integer> lst) {

        int firstMin, secondMin;

        Collections.sort(lst);

        for (int i = 1; i < lst.size(); i++) {
            if (!lst.get(i).equals(firstMin)) {
                return new Integer(lst.get(i));
            }
            firstMin = lst.get(i);
        }

        return null;
    }


    public static void main(String[] args) {

        System.out.println(nextSmallest(Arrays.asList(1, 2, 3, 4, 5))); // Should print: 2

        System.out.println(nextSmallest(Arrays.asList(5, 1, 4, 3, 2))); // Should print: 2

        System.out.println(nextSmallest(Collections.emptyList())); // Should print: null

        System.out.println(nextSmallest(Arrays.asList(1, 1))); // Should print: null

    }

}