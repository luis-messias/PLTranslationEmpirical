import java.util.ArrayList;
import java.util.Scanner;

public class codeforces_672_A {
    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<>();
        // ind is unused in the original logic, we ignore it.
        
        for (int i = 1; i <= 370; i++) {
            // The original logic complexly ensures that i is appended to li.
            // We replicate the structure, although the result is simply appending i.
            
            int temp = 0;
            int q = i;
            int p = i;
            int count = 0;

            // Calculate number of digits (count)
            while (p != 0) {
                p /= 10;
                count++;
            }

            if (count == 1) {
                li.add(i);
            } else if (count == 2) {
                // Extract digits of i in reverse order into temp
                ArrayList<Integer> tempList = new ArrayList<>();
                while (q != 0) {
                    int x = q % 10;
                    q /= 10;
                    tempList.add(x);
                }
                
                // Reverse tempList and append to li
                ArrayList<Integer> reversedTempList = new ArrayList<>();
                for (int j = tempList.size() - 1; j >= 0; j--) {
                    reversedTempList.add(tempList.get(j));
                }
                li.addAll(reversedTempList);
            } else if (count == 3) {
                // Extract digits of i in reverse order into temp
                ArrayList<Integer> tempList = new ArrayList<>();
                while (q != 0) {
                    int x = q % 10;
                    q /= 10;
                    tempList.add(x);
                }

                // Reverse tempList and append to li
                ArrayList<Integer> reversedTempList = new ArrayList<>();
                for (int j = tempList.size() - 1; j >= 0; j--) {
                    reversedTempList.add(tempList.get(j));
                }
                li.addAll(reversedTempList);
            }
        }