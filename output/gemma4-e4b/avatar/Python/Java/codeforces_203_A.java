import java.util.Scanner;
import java.lang.Math;

public class codeforces_203_A {

    public static String mainLogic(int x, int t, int a, int b, int da, int db) {
        // Python: if x == 0 : print ( "YES" ); return "Result Found"
        if (x == 0) {
            System.out.println("YES");
            return "Result Found";
        }

        // Calculate a_time and b_time
        // Math.min handles the min() function. Integer division is standard.
        int a_time = Math.min(a / da, t - 1);
        int b_time = Math.min(b / db, t - 1);

        // Loops iterate from 0 up to a_time/b_time inclusive
        for (int i = 0; i <= a_time; i++) {
            for (int j = 0; j <= b_time; j++) {
                // Condition 1: a