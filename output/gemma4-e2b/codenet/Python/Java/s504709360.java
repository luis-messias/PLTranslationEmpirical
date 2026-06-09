import java.util.Scanner;

public class s504709360 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        if (s.length() < 26) {
            // Case 1: Check if any lowercase letter from 'a' to 'z' is missing
            for (int i = 0; i < 26; i++) {
                char c = (char) ('a' + i);
                if (s.indexOf(c) == -1) {
                    System.out.println(s + c);
                    return