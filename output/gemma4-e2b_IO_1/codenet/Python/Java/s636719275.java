import java.util.Scanner;
import java.lang.Math;

public class s636719275 {
    static int check(String a, String b) {
        int s = 0;
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                s++;
            }
        }
        return s;
