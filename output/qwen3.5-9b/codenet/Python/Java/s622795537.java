import java.util.*;

public class s622795537 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, Integer> arr = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            if (!arr.containsKey(s)) {
                arr.put(s, 1);
            } else {
                arr.put(s, arr.get(s) + 1);
            }
        }
        
        int maxCount = 0;
        for (int count : arr.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        
        List<String> dic = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : arr.entrySet()) {
            if (entry.getValue() == maxCount) {
                dic.add(entry.getKey());
            }
        }
        
        Collections.sort(dic);
        
        for (String s : dic) {
            System.out.println(s);
        }
    }
}