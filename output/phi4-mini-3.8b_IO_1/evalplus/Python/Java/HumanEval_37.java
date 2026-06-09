package com.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HumanEval_37 {
    public static void main(String[] args) {
        List<Integer> result1 = sortEven(new ArrayList<>(Arrays.asList(1, 2, 3)));
        System.out.println(result1); // Output: [1, 2, 3]

        List<Integer> result2 = sortEven(new ArrayList<>(Arrays.asList(5, 6, 3, 4)));
        System.out.println(result2); // Output: [3, 6, 5, 4]
    }

    public static <T extends Comparable<T>> List<T> sortEven(List<T> l) {
        int evenIndex = 0;
        for (int i = 1; i < l.size(); i += 2) { // Start from index 1 to skip odd indices
            if (!l.get(evenIndex).equals(l.get(i))) {
                List<T> tempList = new ArrayList<>(Arrays.asList(l.subList(0, evenIndex + 1)));
                Collections.sort(tempList);
                l.clear();
                for (T item : tempList) {
                    l.add(item);
                }
                if (!l.isEmpty()) { // Add the sorted elements at odd indices
                    List<T> unsortedOdd = new ArrayList<>(Arrays.asList(l.subList(evenIndex + 1, evenIndex + 2)));
                    Collections.sort(unsortedOdd); // Sort only the remaining list for next iteration
                    l.addAll(Arrays.asList(unsortedOdd));
                }
            } else {
                List<T> unsortedEven = new ArrayList<>(Arrays.asList(l.subList(evenIndex + 1, evenIndex + 2)));
                Collections.sort(unsortedEven); // Sort only the remaining list for next iteration
                l.addAll(Arrays.asList(unsortedEven));
            }
            evenIndex += 2;
        }

        return l; // Return sorted and unsorted lists combined as per original logic.
    }
}
