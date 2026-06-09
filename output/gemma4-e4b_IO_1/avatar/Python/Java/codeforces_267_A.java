import java.util.ArrayList;
import java.util.Scanner;

public class codeforces_267_A {

    public static int substract(int a, int b) {
        if (a > b) {
            int total = 0;
            int currentA = a;
            int currentB = b;

            while (currentA > 0 && currentB > 0) {
                // total += int ( a / b )
                total += currentA / currentB;
                
                // a = a % b
                currentA = currentA % currentB;
                
                if (currentA > 0) {
                    // total += int ( b / a )
                    total += currentB / currentA;
                    
                    // b = b % a
                    currentB = currentB % currentA;
                }
            }
            return total;
        } else if (a < b) {
            int total = 0;
            int currentA = a;
            int currentB = b;

            while (currentA > 0 && currentB > 0) {
                // total += int ( b / a )
                total += currentB / currentA;
                
                // b = b % a
                currentB =
