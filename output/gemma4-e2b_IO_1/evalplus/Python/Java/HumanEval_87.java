import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> getRow(List<List<Integer>> lst, int x) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < lst.size(); i++) {
            List<Integer> l = lst.get(i);
            // Iterate columns j in reverse order (descending)
            for (int j = l.size() - 1; j >= 0; j--) {
                if (l.get(j).equals(x)) {
                    // Append coordinate (row, column)
                    List<Integer> coord = new ArrayList<>();
                    coord.add(i); // row
                    coord.add(j); // column
                    res.add(coord);
                }
            }
        }
        return res;
    }
}
