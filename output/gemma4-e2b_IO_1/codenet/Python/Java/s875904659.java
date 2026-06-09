import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Card {
    int value1;
    int value2;

    public Card(int v1, int v2) {
        this.value1 = v1;
        this.value2 = v2;
    }

    @Override
    public String toString() {
        // Mimic the output format: value1 value2
        return String.valueOf(value1) + " " + String.valueOf(value2);
    }
}

public class s875904659 {

    // Bubble Sort implementation
    public static void bubbleSort(List<Card> cards) {
        int n = cards.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // Sort based on the second element (value2)
