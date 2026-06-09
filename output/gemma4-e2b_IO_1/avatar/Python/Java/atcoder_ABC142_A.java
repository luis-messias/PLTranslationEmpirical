import java.util.Scanner;

public class atcoder_ABC142_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n (equivalent to next_int())
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int t = 0;
            
            // Loop equivalent to the Python logic: for i in range(n): if (i + 1) is odd: t +=
