import java.util.Arrays;
import java.util.Scanner;

public class s875904659 {
    public static void bubbleSort(String[] cards) {
        int n = cards.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (cards[j].split(",").length > 1 && cards[j - 1].split(",").length > 1) {
                    if (Integer.parseInt(cards[j].split(",")[1]) < Integer.parseInt(cards[j - 1].split(",")[1])) {
                        String temp = cards[j];
                        cards[j] = cards[j - 1];
                        cards[j - 1] = temp;
                    }
                } else if (cards[j].split(",").length > 1) {
                    cards[j - 1] = cards[j];
                } else if (cards[j - 1].split(",").length > 1) {
                    String temp = cards[j];
                    cards[j] = cards[j - 1];
                    cards[j - 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(cards));
    }

    public static void selectionSort(String[] cards) {
        int n = cards.length;
        for (int i = 0; i < n - 1; i++) {
            int mini = i;
            for (int j = i + 1; j < n; j++) {
                if (cards[j].split(",").length > 1 && cards[mini].split(",").length > 1) {
                    if (Integer.parseInt(cards[j].split(",")[1]) < Integer.parseInt(cards[mini].split(",")[1])) {
                        mini = j;
                    }
                } else if (cards[j].split(",").length > 1) {
                    mini = j;
                }
            }
            if (mini != i) {
                String temp = cards[i];
                cards[i] = cards[mini];
                cards[mini] = temp;
            }
        }

        System.out.println(Arrays.toString(cards));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        String[] cards = input.split(" ");
        String[] cards2 = cards.clone();
        bubbleSort(cards);
        System.out.println("Stable");
        selectionSort(cards2);
        if (Arrays.toString(cards).equals(Arrays.toString(cards2))) {
            System.out.println("Stable");
        } else {
            System.out.println("Not stable");
        }
    }
}
