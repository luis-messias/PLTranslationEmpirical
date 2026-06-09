import java.util.*;

public class HumanEval_70 {

    public static int[] strange_sort_list(int[] lst) {
        List<Integer> sortedList = new ArrayList<>();
        
        for (int i : lst) {
            sortedList.add(i);
        }
        
        Collections.sort(sortedList, Comparator.reverseOrder());
        
        Deque<Integer> ans = new LinkedList<>();
        
        while (!sortedList.isEmpty()) {
            ans.offerFirst(sortedList.get(0));
            
            if (!sortedList.remove(0)) continue;
            
            int maxValIndex = 1;
            for (int i = 2; i < sortedList.size(); i++) {
                if (sortedList.get(i) > sortedList.get(maxValIndex)) {
                    maxValIndex = i;
                }
            }

            ans.offerFirst(sortedList.remove(maxValIndex));
        }
        
        int[] resultArray = new int[ans.size()];
        
        for (int i = 0; i < ans.size(); i++) {
            resultArray[i] = ans.get(i);
        }
        
        return resultArray;
    }
}
