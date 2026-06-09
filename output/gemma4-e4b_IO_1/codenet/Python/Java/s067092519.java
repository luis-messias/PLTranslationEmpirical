import java.util.Scanner;

public class s067092519 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        int N = scanner.nextInt();
        
        // m[10][3][10]
        int[][][] m = new int[10][3][10];
        
        for (int i = 0; i < N; i++) {
            if
