import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class codeforces_222_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and k from the first line
        if (!scanner.hasNextLine()) return;
        String line1 = scanner.nextLine();
        String[] nk = line1.split(" ");
        if (nk.length < 2) return;
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        // Read elems from the second line
        if (!scanner.hasNextLine()) return;
        String line2 = scanner.nextLine();
        String[] elemsStr = line2.split(" ");
        
        List<Integer> elems = new ArrayList<>();
        for (String s : elemsStr) {
            elems.add(Integer.parseInt(s));
        }

        // Python logic translation
        
        // all_same check helper
        java.util.function.Predicate<List<Integer>> allSame = arr -> {
            if (arr.isEmpty()) return true;
            int first = arr.get(0);
            for (int i = 1; i < arr.size(); i++) {
                if (!arr.get(i).equals(first)) {
                    return false;
                }
            }
            return true;
        };

        // 1. if all_same (elems):
        if (allSame.test(elems)) {
            System.out.println(0);
            return;
        }

        // 2. if k == 1:
        if (k == 1) {
            System.out.println(-1);
            return;
        }

        // 3. if not all_same (elems[k - 1:]):
        // elems[k-1:] is the suffix starting from index k-1
        List<Integer> suffix = elems.subList(k - 1, elems.size());
        boolean suffixAllSame = allSame.test(suffix);
        
        if (!suffixAllSame) {
            System.out.println(-1);
            return;
        }

        // If we reach here, the suffix elems[k-1:] is all the same.
        // This implies that the first k-1 elements (to_delete) must be the ones we are considering removing.
        
        // target = elems[-1]
        int target = elems.get(elems.size() - 1);
        
        // to_delete = elems[0 : k-1]
        List<Integer> toDelete = elems.subList(0, k - 1);

        // while to_delete and to_delete[-1] == target: to_delete.pop()
        // Since toDelete is a view/sublist, we need to operate on a mutable list copy if we want to pop.
        // The Python code modifies 'to_delete' in place.
        
        // Convert toDelete to a mutable list for popping
        List<Integer> mutableToDelete = new ArrayList<>(toDelete);
        
        while (!mutableToDelete.isEmpty() && mutableToDelete.get(mutableToDelete.size() - 1).equals(target)) {
            mutableToDelete.remove(mutableToDelete.size() - 1);
        }

        // print(len(to_delete))
        System.out.println(mutableToDelete.size());
    }
}