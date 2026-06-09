import java.util.Scanner;

public class codeforces_678_B {
    public static String leapYear(int n) {
        if ((n % 400 == 0 || (n % 4 == 0 && n % 100 != 0))) {
            return "y";
        } else {
            return "n";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String d = "f";
        String ans = (leapYear(n) == "y") ? "ly" : "nly";

        while (true) {
            if ((n % 400 == 0 || (n % 4 == 0 && n % 100 != 0))) {
                switch (d) {
                    case "m":
                        d = "w";
                        break;
                    case "t":
                        d = "th";
                        break;
                    case "w":
                        d = "f";
                        break;
                    case "th":
                        d = "sa";
                        break;
                    case "f":
                        d = "s";
                        break;
                    case "sa":
                        d = "m";
                        break;
                    case "s":
                        d = "t";
                        break;
                }
            } else {
                switch (d) {
                    case "m":
                        d = "t";
                        break;
                    case "t":
                        d = "w";
                        break;
                    case "w":
                        d = "th";
                        break;
                    case "th":
                        d = "f";
                        break;
                    case "f":
                        d = "sa";
                        break;
                    case "sa":
                        d = "s";
                        break;
                    case "s":
                        d = "m";
                        break;
                }
            }

            if ((d.equals("f") && ans.equals("ly")) && leapYear(n).equals("y")) {
                break;
            } else if ((d.equals("f") && ans.equals("nly")) && leapYear(n).equals("n")) {
                break;
            }
            n++;
        }
        System.out.println(n);
    }
}