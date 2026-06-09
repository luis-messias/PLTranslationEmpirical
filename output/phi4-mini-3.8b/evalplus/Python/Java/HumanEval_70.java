package com.example;
public class HumanEval_70 {

    public static int[] strange_sort_list(int[] lst) {

        Arrays.sort(lst);

        List<Integer> sortedList = new ArrayList<>();

        for (int i : lst) {
            sortedList.add(i);
        }

        Deque<Integer> ans = new LinkedList<>();

        while (!sortedList.isEmpty()) {

            ans.offer(sortedList.get(0));

            if (!sortedList.removeFirst()) continue;

            int maxValIndex = 1;
            for (int i = 2; i < sortedList.size(); i++) {
                if (sortedList.get(i) > sortedList.get(maxValIndex)) {
                    maxValIndex = i;
                }
            }

            ans.offer(sortedList.remove(maxValIndex));

        }

        int[] resultArray = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {

            resultArray[i] = ans.get(i);

        }

        return resultArray;

    }


}