import java.util.Scanner;

public class codeforces_632_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        int[] pieces = new int[n];
        for (int i = 0; i < n; i++) {
            pieces[i] = Integer.parseInt(input1.split(" ")[i]);
        }

        System.out.println(BobSMaxStrength(pieces, input2));
    }

    public static int BobSMaxStrength(int[] pieces, String s) {
        int pScore = 0;
        int sScore = 0;
        int pMaxScore = Integer.MIN_VALUE;
        int sMaxScore = Integer.MIN_VALUE;

        for (int i = 0; i < pieces.length; i++) {
            if (s.charAt(i) == 'B') {
                pScore += pieces[i];
                sScore -= pieces[i];
            } else if (s.charAt(i) == 'A') {
                pScore -= pieces[i];
                sScore += pieces[i];
            }
        }

        for (int i = pieces.length - 1; i >= 0; i--) {
            if (s.charAt(pieces.length - 1 - i) == 'B') {
                pScore += pieces[pieces.length - 1 - i];
                sScore -= pieces[pieces.length - 1 - i];
            } else if (s.charAt(pieces.length - 1 - i) == 'A') {
                pScore -= pieces[pieces.length - 1 - i];
                sScore += pieces[pieces.length - 1 - i];
            }
        }

        return Math.max(pMaxScore, sMaxScore);
    }
}
