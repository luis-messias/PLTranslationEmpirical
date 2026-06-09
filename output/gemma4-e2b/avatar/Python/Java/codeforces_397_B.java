import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CodeforcesTask397BSolution {
    private String result = "";
    private int t = 0;
    private List<int[]> queries = new ArrayList<>();

    public void readInput(Scanner scanner) {
        if (scanner.hasNextInt()) {
            this.t = scanner.nextInt();
        }
        for (int i = 0; i < this.t; i++) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Read A, B, C from the line
                String[] parts = line.trim().split("\\s+");
                if (parts.length == 3) {
                    int a = Integer.parseInt(parts[0]);
                    int b = Integer.parseInt(parts[1]);
                    int c = Integer.parseInt(parts[2]);
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
        
        // Read input
        solution.readInput(scanner);
        
        // Process task
        solution.processTask();
        
        // Print result
        System.out.println(solution.getResult());
        
        scanner.close();
    }
}