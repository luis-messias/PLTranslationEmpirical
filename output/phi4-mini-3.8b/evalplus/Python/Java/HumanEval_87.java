package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HumanEval_87 {

    public static ArrayList<int[]> getRow(ArrayList<ArrayList<Integer>> lst, int x) {
        ArrayList<int[]> res = new ArrayList<>();
        
        for (int i = 0; i < lst.size(); i++) {
            ListIterator<Integer> it = lst.get(i).listIterator(lst.get(i).size() - 1);
            
            while (it.hasPrevious()) {
                if (it.previous().equals(x)) {
                    res.add(new int[]{i, it.previousIndex});
                }
                
                it.previous();
            }
        }

        Collections.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // Sort by columns in descending order for each row after sorting rows.
        ArrayList<Integer> indices = new ArrayList<>();
        res.forEach(pair -> indices.add(pair[1]));
        
        Collections.sort(indices, Comparator.reverseOrder());
        
        int[] sortedIndices = indices.stream().mapToInt(i->i).toArray();
        return res;
    }

    public static void main(String[] args) {
        // Test cases can be added here to validate the function.
    }
}