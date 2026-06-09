import java.util.*;

public class atcoder_AGC003_C {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= 100000; i++) {
            set.add(i);
        }
        
        int count = 0;
        for (String s : args) {
            if (!set.contains(Integer.parseInt(s))) {
                set.remove(Integer.parseInt(s));
                count++;
            }
        }
        
        System.out.println(count);
    }
}
