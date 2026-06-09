import java.util.Scanner;

public class codeforces_678_B {

    // Helper function equivalent to Python's leapyear(n)
    public static String leapyear(int n) {
        if ((n % 400 == 0) || ((n % 4 == 0) && (n % 100 != 0))) {
            return "y";
        } else {
            return "n";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the starting year n
        int n = scanner.nextInt();
        scanner.close();

        String d = "f"; // Initial day name
        String ans;

        // Determine initial state (ans)
        if (leapyear(n).equals("y")) {
            ans = "ly";
        } else {
            ans = "nly";
        }

        while (true) {
            String currentLeapStatus = leapyear(n);

            // --- Day and Year Advancement Logic ---
            if (currentLeapStatus.equals("y")) {
                // Case 1: Leap Year
                if (d.equals("m")) {
                    d = "w";
                    n += 1;
                } else if (d.equals("t")) {
                    d = "th";
                    n += 1;
                } else if (d.equals("w")) {
                    d = "f";
                    n += 1;
                } else if (d.equals("th")) {
                    d = "sa";
                    n += 1;
                } else if (d.equals("f")) {
                    d = "s";
                    n += 1;
                } else if (d.equals("sa")) {
                    d = "m";
                    n += 1;
                } else if (d.equals("s")) {
                    d = "t";
                    n += 1;
                }
            } else {
                // Case 2: Not a Leap Year
                if (d.equals("m")) {
                    d = "t";
                    n += 1;
                } else if (d.equals("t")) {
                    d = "w";
                    n += 1;
                } else if (d.equals("w")) {
                    d = "th";
                    n += 1;
                } else if (d.equals("th")) {
                    d = "f";
                    n += 1;
                } else if (d.equals("f")) {
                    d = "sa";
                    n += 1;
                } else if (d.equals("sa")) {
                    d = "s";
                    n += 1;
                } else if (d.equals("s")) {
                    d = "m";
                    n += 1;
                }
            }

            // --- Break Conditions ---
            if (d.equals("f")) {
                if (ans.equals("ly") && leapyear(n).equals("y")) {
                    break;
                } else if (ans.equals("nly") && leapyear(n).equals("n")) {
                    break;
                }
            }
        }

        System.out.println(n);
    }
}