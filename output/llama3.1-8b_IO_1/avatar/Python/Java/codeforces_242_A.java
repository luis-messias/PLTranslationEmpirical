import java.util.Scanner;
import java.util.ArrayList;

public class codeforces_242_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int a = Integer.parseInt(input[2]);
        int b = Integer.parseInt(input[3]);

        ArrayList<int[]> games = new ArrayList<>();

        for (int i = a; i <= x; i++) {
            if (i > b) continue;
            else {
                for (int j = b; j <= y; j++) {
                    if (j < i) {
                        games.add(new int[] {i, j});
                    }
                }
            }
        }

        System.out.println(games.size());
        for (int[] game : games) {
            System.out.println(game[0] + " " + game[1]);
        }
    }
}
