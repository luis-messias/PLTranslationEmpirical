import java.util.Scanner;

public class s797394058 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read N
        if (scanner.hasNextInt()) {
            int N = scanner.nextInt();

            // The Python code calculates N^3.
            // N_list = [2, 2, ..., 2] (N times)
            // n = product(N_list, repeat=3) results in N*N*N elements.
            long m = (long) N * N * N;

            System.out.println(m);
        }
        scanner.close();
    }
}