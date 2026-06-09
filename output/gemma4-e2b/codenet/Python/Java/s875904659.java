import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Card {
    String[] data;

    public Card(String s1, String s2) {
        this.data = new String[]{s1, s2};
    }

    public String[] getData() {
        return data;
    }

    @Override
    public String toString() {
        // Mimic the Python output format