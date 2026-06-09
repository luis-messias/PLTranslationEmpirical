import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class codeforces_287_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<String>> t = new ArrayList<>();
        
        for (int i = 0; i < 4; i++) {
            String line = scanner.nextLine();
            List<String> row = new ArrayList<>();
            for (int j = 0; j < line.length(); j++) {
                row.add(String.valueOf(line.charAt(j)));
            }
            t.add(row);
        }
        
        int correct = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int black = 0;
                int white = 0;
                
                if (t.get(i).get(j).equals("#")) {
                    black++;
                } else {
                    white++;
                }
                if (t.get(i).get(j + 1).equals("#")) {
                    black++;
                } else {
                    white++;
                }
                if (t.get(i + 1).get(j).equals("#")) {
                    black++;
                } else {
                    white++;
                }
                if (t.get(i + 1).get(j + 1).equals("#")) {
                    black++;
                } else {
                    white++;
                }
                
                if (black == 0 || black == 3 || white == 0 || white == 3 || white == 4 || black == 4) {
                    correct = 1;
                    break;
                }
            }
            if (correct == 1) {
                break;
            }
        }
        
        if (correct == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
