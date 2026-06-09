import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class codeforces_397_B {
    private String result = "";
    private int t = 0;
    private List<int[]> queries = new ArrayList<>();

    public void readInput(Scanner scanner) {
        if (scanner.hasNextInt()) {
            this.t = scanner.nextInt();
        }
        
        for (int i = 0; i < this.t; i++) {
            if (scanner.hasNextInt()) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                this.queries.add(new int[]{a, b, c});
            }
        }
    }

    public void processTask() {
        List<String> res = new ArrayList<>();
        
        for (int[] query : this.queries) {
            int a = query[0];
            int b = query[1];
            int c = query[2];

            // k = A // B (integer division)
            // Since A and B are positive in typical competitive programming contexts, 
            // standard integer division works for floor division.
            int k = a / b;
            
            // Check if k * C >= A. Use long casting to prevent potential integer overflow.
            if ((long)k * c >= a) {
                res.add("Yes");
            } else {
                res.add("No");
            }
        }
        
        this.result = String.join("\n", res);
    }

    public String getResult() {
        return this.result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CodeforcesTask397BSolution solution = new CodeforcesTask397BSolution();
        
        // Read input
        solution.readInput(scanner);
        
        // Process the task
        solution.processTask();
        
        // Print the result
        System.out.println(solution.getResult());
        
        scanner.close();
    }
}
