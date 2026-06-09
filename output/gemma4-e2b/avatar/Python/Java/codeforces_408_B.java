import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class codeforces_408_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first line (bought items)
        if (!scanner.hasNextLine()) {
            return;
        }
        String line1 = scanner.nextLine();

        // Read the second line (made items)
        if (!scanner.hasNextLine()) {
            return;
        }
        String line2 = scanner.nextLine();

        // Calculate bought_count
        Map<String, Integer> boughtCount = new HashMap<>();
        String[] boughtItems = line1.trim().split("\\s+");
        for (String item : boughtItems) {
            if (!item.isEmpty()) {
                boughtCount.put(item, boughtCount.getOrDefault(item, 0) + 1);
            }
        }

        // Calculate made_cout
        Map<String, Integer> madeCount = new HashMap<>();
        String[] madeItems = line2.trim