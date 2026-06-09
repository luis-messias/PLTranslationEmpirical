import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class s411244720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);
        
        Set<Integer> S = new HashSet<>();
        
        for (int i = 0; i < K; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            for (String part : parts) {
                S.add(Integer.parseInt(part));
            }
        }
        
        System.out.println(N - S.size());
    }
}
