import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CodeforcesTask397BSolution {
    private String result = "";
    private List<int[]> queries = new ArrayList<>();

    public void readInput(Scanner scanner) {
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            for (int i = 0; i < t; i++) {
                if (scanner.hasNextInt()) {
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    int c = scanner.nextInt();
                    queries.add(new int[]{a, b, c});
                }
            }
        }
    }

    public void processTask() {
        List<String> res = new ArrayList<>();
        for (int[] query : this.queries) {
            int a = query[0];
            int b = query[1];
            int c = query[2];

            // k = a // b (integer division)
            int k = a / b;
            
            // Check if k * c >= a
            if (k * c >= a) {
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
        
        solution.readInput(scanner);
        solution.processTask();
        
        System.out.println(solution.getResult());
        
        scanner.close();
    }
}
