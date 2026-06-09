import java.util.*;

public class s668439281 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(scanner.nextLine());
        }
        
        Map<String, Integer> c = new HashMap<>();
        for (String s : ls) {
            c.put(s, c.getOrDefault(s, 0) + 1);
        }

        int count = Collections.max(c.values());
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : c.entrySet()) {
            if (entry.getValue() == count) {
                ans.add(entry.getKey());
            } else {
                break;
            }
        }
        
        Collections.sort(ans);
        int index = 0;
        while(index < ans.size()){
            String s = ans.get(index);
            boolean found = false;
            for(String str : ls){
                if(str.equals(s)){
                    found = true;
                    break;
                }
            }
            if(found){
                System.out.println(s);
                ans.remove(index);
            }else{
                index++;
            }
        }
    }
}
