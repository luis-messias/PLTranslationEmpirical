import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces_287_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<String>> t = new ArrayList<>();

        // Read 4 lines of input
        for (int i = 0; i < 4; i++) {
            if (scanner.hasNextLine()) {
                // Read the line and convert it to a list of characters/strings
                String line = scanner.nextLine();
                // The Python code uses list(map(str, input())), which implies reading characters/strings.
                // We store the line as a list of characters/strings.
                List<String> row = new ArrayList<>();
                for (char c : line.toCharArray()) {
                    row.add(String.valueOf(c));
                }
                t.add(row);
            } else {
                // Handle case where input ends prematurely if necessary, though usually not expected in this context
                break;
            }
        }

        int black = 0;
        int white = 0;
        int correct = 0;

        // Check the 3x3 area within the 4x4 grid t
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Check t[i][j]
                if (t.get(i).get(j).equals("#")) {
                    black++;
                } else {
                    white++;
                }

                // Check t[i][j+1]
                if (j + 1 < t.get(i).size()) {
                    if (t.get(i).get(j + 1).equals("#")) {
                        black++;
                    } else {
                        white++;
                    }
                } else {
                    // Safety break if j+1 is out of bounds (shouldn't happen if input is 4x4)
                }

                // Check t[i+1][j]
                if (i + 1 < t.size()) {
                    if (t.get(i + 1).get(j).equals("#")) {
                        black++;
                    } else {
                        white++;
                    }
                }

                // Check t[i+1][j+1]
                if (i + 1 < t.size() && j + 1 < t.get(i + 1).size()) {
                    if (t.get(i + 1).get(j + 1).equals("#")) {
                        black++;
                    } else {
                        white++;
                    }
                }

                // Check the condition
                if (black == 0 || black == 3 || white == 0 || white == 3 || white == 4 || black == 4) {
                    correct = 1;
                    break; // Break inner loop (j)
                }

                // Reset counters for the next iteration of j
                black = 0;
                white = 0;
            }
            if (correct == 1) {
                break; // Break outer loop (i)
            }
        }

        if (correct == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        scanner.close();
    }
}