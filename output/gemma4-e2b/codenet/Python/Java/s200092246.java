import java.util.Scanner;

public class s200092246 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        int ans0 = -1;
        int ans1 = -1;
        long currentSum = 0;
        int i = 1;

        // Find the smallest i such that sum(1..i) >= N
        while (true) {
            currentSum += i;
            if (currentSum >= N) {
                ans0 = i - 1;
                ans1 = (int) (currentSum - N);