package com.example;
import java.util.ArrayList;
import java.util.Collections;

public class HumanEval_33 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3);
        System.out.println(sortThird(list));

        list.clear();
        Collections.addAll(list, 5, 6, 3, 4, 8, 9, 2);
        System.out.println(sortThird(list));
    }

    public static ArrayList<Integer> sortThird(ArrayList<Integer> l) {
        int thirdIndex = -1;
        for (int i = 0; i < l.size(); i++) {
            if ((i + 1) % 3 == 0) { // Java uses zero-based indexing
                thirdIndex++;
                ArrayList<Integer> tempThird = new ArrayList<>(l.subList(thirdIndex * 2, Math.min(l.size(), (thirdIndex + 1) * 2)));
                Collections.sort(tempThird);
                l.set(thirdIndex * 2, tempThird.get(0));
            }
        }

        return l;
    }
}