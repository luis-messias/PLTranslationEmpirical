import java.util.Scanner;

public class codeforces_629_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] cake = new String[n][n];
        double happiness = 0;
        int chocCount = 0;
        int nfat = 1;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            cake[i] = line.split("");
            for (String j : cake[i]) {
                if (j.equals("C")) {
                    chocCount++;
                }
            }
            if (chocCount > 1) {
                int k = chocCount;
                while (k >= 3) {
                    nfat *= k--;
                }
                happiness += nfat / 2.0;
            }
            nfat = 1;
            chocCount = 0;
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (cake[i][j].equals("C")) {
                    chocCount++;
                }
            }
            if (chocCount > 1) {
                int k = chocCount;
                while (k >= 3) {
                    nfat *= k--;
                }
                happiness += nfat / 2.0;
            }
            nfat = 1;
            chocCount = 0;
        }

        System.out.println((int) happiness);
    }
}
