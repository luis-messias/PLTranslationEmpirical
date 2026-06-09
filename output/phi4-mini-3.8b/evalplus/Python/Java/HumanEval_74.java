package com.example;
import java.util.List;

public class HumanEval_74 {

    public static <T extends CharSequence> List<T> totalMatch(List<T> list1, List<T> list2) {
        int sumList1 = list1.stream().mapToInt(String::length).sum();
        int sumList2 = list2.stream().mapToInt(String::length).sum();

        return (sumList1 <= sumList2 ? list1 : list2);
    }

}