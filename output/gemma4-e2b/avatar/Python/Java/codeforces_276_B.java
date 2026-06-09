import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class codeforces_276_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // s = list ( input ( ) )
        // Assuming input is read as a line of space-separated tokens
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        
        // Split the input into a list of strings (s)
        String[] tokens = line.trim().split("\\s+");
        List<String> s = new ArrayList<>();
        for (String token : tokens) {
            if (!token.isEmpty()) {
                s.add(token);
            }
        }

        // dt = { } (Frequency map)
        Map<String, Integer> dt = new HashMap<>();
        for (String i : s) {
            dt.put(i, dt.getOrDefault(i, 0) + 1);
        }

        // cnt = 0
        int cnt = 0;
        // x = True
        boolean x = true;

        // Iterate through the map
        for (Map.Entry<String, Integer> entry : dt.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (value % 2 != 0 && cnt < 1) {
                cnt++;
            } else if (value % 2 != 0 && cnt >= 1) {
                x = false;
                break;
            }
        }

        // Final conditional printing
        if (x) {
            System.out.println("First");
        } else if (!x && s.size() % 2 == 0) {
            System.out.println("Second");
        } else if (!x && s.size() % 2 != 0) {
            System.out.println("First");
        }

        scanner.close();
    }
}