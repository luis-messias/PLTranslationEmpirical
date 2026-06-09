import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class codeforces_462_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and k from the first line: n, k = map(int, input().split())
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int k = scanner.nextInt();

        // Read s from the second line: s = input()
        if (!scanner.hasNext()) return;
        String s = scanner.next();

        // 1. Frequency counting
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'A']++;
        }

        // 2. Sort counts in reverse order (descending)
        // Use Integer array for reverse sorting
        Integer[] countObj = new Integer[26];
        for (int i = 0; i < 26; i++) {
            countObj[i] = count[i];
        }
        Arrays.sort(countObj, Collections.reverseOrder());
        
        // Convert back to int array for easier access
        int[] sortedCount = new int[26];
        for (int i = 0; i < 26; i++) {
            sortedCount[i] = countObj[i];
