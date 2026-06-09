import java.util.Scanner;

public class codeforces_678_B {
    public static String leapyear(int n) {
        if (n % 400 == 0 || (n % 4 == 0 && n % 100 != 0)) {
            return "y";
        } else {
            return "n";
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String d = "f";
        String ans = leapyear(n);
        
        if (n % 400 == 0 || (n % 4 == 0 && n % 100 != 0)) {
            ans = "ly";
        } else {
            ans = "nly";
        }
        
        while (true) {
            if (n % 400 == 0 || (n % 4 == 0 && n % 100 != 0)) {
                if (d.equals("m")) {
                    d = "w";
                    n++;
                } else if (d.equals("t")) {
                    d = "th";
                    n++;
                } else if (d.equals("w")) {
                    d = "f";
                    n++;
                } else if (d.equals("th")) {
                    d = "sa";
                    n++;
                } else if (d.equals("f")) {
                    d = "s";
                    n++;
                } else if (d.equals("sa")) {
                    d = "m";
                    n++;
                } else if (d.equals("s")) {
                    d = "t";
                    n++;
                }
            } else {
                if (d.equals("m")) {
                    d = "t";
                    n++;
                } else if (d.equals("t")) {
                    d = "w";
                    n++;
                } else if (d.equals("w")) {
                    d = "th";
                    n++;
                } else if (d.equals("th")) {
                    d = "f";
                    n++;
                } else if (d.equals("f")) {
                    d = "sa";
                    n++;
                } else if (d.equals("sa")) {
                    d = "s";
                    n++;
                } else if (d.equals("s")) {
                    d = "m";
                    n++;
                }
            }
            
            if (d.equals("f") && ans.equals("ly") && leapyear(n).equals("y")) {
                break;
            } else if (d.equals("f") && ans.equals("nly") && leapyear(n).equals("n")) {
                break;
            }
        }
        
        System.out.println(n);
    }
}
