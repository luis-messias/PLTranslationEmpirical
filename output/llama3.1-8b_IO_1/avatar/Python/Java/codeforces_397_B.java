import java.util.Scanner;

public class codeforces_397_B {
    public String solve() {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] line = scanner.nextLine().split(" ");
            int k = Integer.parseInt(line[0]) / Integer.parseInt(line[1]);
            res.append((k * Integer.parseInt(line[2]) >= Integer.parseInt(line[0]) ? "Yes" : "No")).append("\n");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        CodeforcesTask397BSolution instance = new CodeforcesTask397BSolution();
        String result = instance.solve();
        System.out.println(result);
    }
}
