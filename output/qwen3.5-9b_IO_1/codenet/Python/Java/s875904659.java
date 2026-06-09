import java.util.*;

public class s875904659 {
    public static void bubbleSort(String[] cards) {
        int n = cards.length;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (Integer.parseInt(cards[j].split(" ")[1]) < Integer.parseInt(cards[j - 1].split(" ")[1])) {
                    String temp = cards[j];
                    cards[j] = cards[j - 1];
                    cards[j - 1] = temp;
                }
            }
        }
        System.out.println(String.join(" ", cards));
    }

    public static void selectionSort(String[] cards) {
        int n = cards.length;
        for (int i = 0; i < n; i++) {
            int mini = i;
            for (int j = i; j < n; j++) {
                if (Integer.parseInt(cards[j].split(" ")[1]) < Integer.parseInt(cards[mini].split(" ")[1])) {
                    mini = j;
                }
            }
            if (mini != i) {
                String temp = cards[i];
                cards[i] = cards[mini];
                cards[mini] = temp;
            }
        }
        System.out.println(String.join(" ", cards));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] cards = sc.next().split(" ");
        String[] cards2 = cards.clone();
        bubbleSort(cards);
        System.out.println("Stable");
        selectionSort(cards2);
        if (String.join(" ", cards2).equals(String.join(" ", cards))) {
            System.out.println("Stable");
        } else {
            System.out.println("Not stable");
        }
    }
}
