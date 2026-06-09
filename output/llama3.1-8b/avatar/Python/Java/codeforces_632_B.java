import java.util.Scanner;

public class codeforces_632_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        int[][] pieces = new int[input1.split(" ").length][2];
        for (int i = 0; i < input1.split(" ").length; i++) {
            pieces[i][0] = Integer.parseInt(input1.split(" ")[i]);
            pieces[i][1] = input2.charAt(i);
        }

        System.out.println(BobSMaxStrength(pieces));
    }

    public static int BobSMaxStrength(int[][] pieces) {
        int pScore = 0, sScore = 0, pMaxScore = Integer.MIN_VALUE, sMaxScore = Integer.MIN_VALUE;
        for (int[] piece : pieces) {
            if (piece[1] == 'B') {
                pScore += piece[0];
                sScore -= piece[0];
            } else if (piece[1] == 'A') {
                pScore -= piece[0];
                sScore += piece[0];
            }
        }

        for (int i = pieces.length - 1; i >= 0; i--) {
            int[] piece = pieces[i];
            if (piece[1] == 'B') {
                pScore += piece[0];
                sScore -= piece[0];
            } else if (piece[1] == 'A') {
                pScore -= piece[0];
                sScore += piece[0];
            }
        }

        return Math.max(pMaxScore, sMaxScore);
    }
}