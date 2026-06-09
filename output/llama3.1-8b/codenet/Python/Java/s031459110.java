import java.util.Scanner;

public class s031459110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String c = scanner.nextLine();

        int numW = countChar(c, 'W');
        int numR = N - numW;

        StringBuilder comp = new StringBuilder();
        for (int i = 0; i < numR; i++) {
            comp.append('R');
        }
        for (int i = 0; i < numW; i++) {
            comp.append('W');
        }

        int ans = 0;
        for (int i = 0; i < Math.min(numR, c.length()); i++) {
            if (i >= c.length() || c.charAt(i) != comp.charAt(i)) {
                ans++;
            }
        }

        ans = Math.min(Math.min(numW, numR), ans);
        System.out.println(ans);
    }

    private static int countChar(String str, char c) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }
}