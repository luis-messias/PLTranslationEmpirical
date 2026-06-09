import java.util.Scanner;

public class codeforces_397_B {
    private String result = "";
    private int t = 0;
    private int[][] queries;
    
    public void readInput() {
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        queries = new int[t][3];
        for (int i = 0; i < t; i++) {
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
            queries[i][2] = scanner.nextInt();
        }
    }
    
    public void processTask() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int k = queries[i][0] / queries[i][1];
            if (k * queries[i][2] >= queries[i][0]) {
                res.append("Yes\n");
            } else {
                res.append("No\n");
            }
        }
        result = res.toString();
    }
    
    public String getResult() {
        return result;
    }
    
    public static void main(String[] args) {
        CodeforcesTask397BSolution solution = new CodeforcesTask397BSolution();
        solution.readInput();
        solution.processTask();
        System.out.println(solution.getResult());
    }
}
