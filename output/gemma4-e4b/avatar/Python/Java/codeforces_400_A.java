import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class codeforces_400_A {

    // Helper function to read a list of integers from a single line
    private static List<Integer> inlsts(Scanner scanner) {
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        return list;
    }

    // Helper function to read a single integer
    private static int inp(Scanner scanner) {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return 0;
    }

    // Helper