import java.util.Scanner;

public class atcoder_ARC062_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int numG = 0, numP = 0;
        int score = 0;
        for (char x : s.toCharArray()) {
            if (x == 'g') {
                if (numG - numP > 0) {
                    score++;
                    numP++;
                } else {
                    score = score;
                    numG++;
                }
            } else if (x == 'p') {
                if (numG - numP > 0) {
                    score = score;
                    numP++;
                } else {
                    score--;
                    numG++;
                }
            }
        }
        System.out.println(score);
    }
}