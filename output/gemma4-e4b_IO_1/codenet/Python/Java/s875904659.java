import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class s875904659 {

    // Helper function to print the array contents in the required format
    private static void printCards(String[][] cards) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                sb.append(cards[i][j]);
                if (j < cards[i].length - 1) {
                    sb.append(" ");
                }
            }
            if (i < cards.length - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    // Bubble Sort implementation
    public static void bubbleSort(String[][] cards) {
        int n = cards.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                // Compare based on the second element (index 1)
                // Assuming cards[j][1] and cards[j-1][1] are valid integers
                int valJ = Integer.parseInt(cards[j][1]);
                int valJMinus1 = Integer.parseInt(cards[j - 1][1]);

                if (valJ < valJMinus1) {
                    // Swap cards[j] and cards[j-1]
                    String[][] temp = cards[j];
                    cards[j] = cards[j - 1];
                    cards[j - 1] = temp;
                }
            }
