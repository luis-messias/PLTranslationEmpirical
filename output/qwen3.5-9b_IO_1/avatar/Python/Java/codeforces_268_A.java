import java.util.Scanner;
import java.util.ArrayList;

public class codeforces_268_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String[]> q = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split(" ");
            q.add(parts);
        }
        
        int count = 0;
        for (int i = 0; i < q.size(); i++) {
            for (int j = 0; j < q.size(); j++) {
                if (i == j) {
                    continue;
                }
                String first = q.get(i)[0];
                String last = q.get(j)[q.get(j).length - 1];
                if (first.equals(last)) {
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }
}
