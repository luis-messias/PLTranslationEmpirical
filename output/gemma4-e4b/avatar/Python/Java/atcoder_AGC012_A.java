import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class atcoder_AGC012_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read A (assuming all remaining tokens are elements of A)
        List<Integer> listA = new ArrayList<>();
        while (scanner.hasNextInt()) {
            listA.add(scanner.nextInt());
        }
        
        // Convert List<Integer> to int[]
        int[] A = new int[listA.size()];
        for (int i = 0; i < listA.size(); i++) {
            A[i] = listA.get(i);
        }

        // Sort A
        Arrays.sort(A);