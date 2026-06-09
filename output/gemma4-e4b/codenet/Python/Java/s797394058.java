import java.util.Scanner;

public class s797394058 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read N
        int N = scanner.nextInt();
        
        // The Python code calculates the size of the Cartesian product of N_list (which has length N) 
        // with itself 3 times. The size is N * N * N.
        // We use long to prevent potential integer overflow for N^3.
        long m = (long) N * N * N;
        
        System.out.println(m);
    }
}