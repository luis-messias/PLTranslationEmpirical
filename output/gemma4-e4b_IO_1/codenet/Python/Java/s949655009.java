import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class s949655009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strn = scanner.nextLine();
        long n = Long.parseLong(strn);
        scanner.close();

        String[] shichigolist = {"3", "5", "7"};
        int L = strn.length();

        // shichigo[i] stores combinations of length i+1
        List<List<String>> shichigo = new ArrayList<>(L);
        for (int i = 0; i < L; i++) {
            shichigo.add(new ArrayList<>());
        }

        // 1. Generation Phase
        // i represents the index (length - 1)
        for (int i = 0; i < L; i++) {
            if (i == 0) {
                // Length 1
                for (String j : shichigolist) {
                    shichigo.get(i).add(j);
                }
            } else {
                // Length i+1
                List<String> previousCombinations = shichigo.get(i - 1);
                for (String j : previousCombinations) {
                    for (String k : shichigolist) {
                        shichigo.get(i).add(j + k);
                    }
                }
            }
        }

        // 2. Filtering Phase
        int targetIndex = L - 1;

        for (int i = 0; i < L; i++) {
            List<String> currentList = shichigo.get(i);
            
            // We must iterate over a copy or use an Iterator to safely remove elements
            // We use a temporary list to store elements to be removed
            List<String> toRemove = new ArrayList<>();

            for (String j : currentList) {
                boolean shouldRemove = false;

                if (i == targetIndex) {
                    // Target length filtering
                    
                    // Check 1: If number > N
                    try {
                        long val = Long.parseLong(j);
                        if (val > n) {
                            shouldRemove = true;
                        }
                    } catch (
