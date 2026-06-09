import java.util.ArrayList;
import java.util.Scanner;

public class codeforces_672_A {
    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<>();
        
        for (int i = 1; i <= 370; i++) {
            int count = 0;
            int p = i;
            
            // Count digits
            int tempP = p;
            while (tempP != 0) {
                tempP /= 10;
                count++;
            }
            
            if (count == 1) {
                li.add(i);
            } else if (count == 2) {
                // Extract digits
                ArrayList<Integer> tempDigits = new ArrayList<>();
                int q = i;
                while
