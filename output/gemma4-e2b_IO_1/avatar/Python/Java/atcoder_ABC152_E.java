import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class atcoder_ABC152_E {

    static final long MOD = 1000000007L;

    // Function to calculate GCD using Euclidean algorithm
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate modular exponentiation (a^b % mod)
    static long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }

    // Function to calculate modular inverse using Fermat's Little Theorem
    // a^(MOD-2) % MOD
    static long modInverse(long n) {
        return power(n, MOD - 2);
    }

    // Function to calculate LCM(a, b) = (a * b) / gcd(a, b)
    // We use the safer form: (a / gcd(a, b)) * b to prevent overflow if a*b is huge,
    // although here we are dealing with LCM of potentially large numbers.
    static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        // Since a and b are positive, gcd(a, b) is positive.
        // We calculate (a / gcd(a, b)) * b
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N (not strictly needed for the logic flow if we read the next line directly)
        // N = int ( input ( ) )
        String lineN = br.readLine();
        if (lineN == null) return;
        // N is read but not used explicitly in the subsequent logic flow based on the Python structure
        // int N = Integer.parseInt(lineN); 

        // Read A = list ( map ( int , input ( ).split ( ) ) )
        String lineA = br.readLine();
        if (lineA == null) return;
        StringTokenizer st = new StringTokenizer(lineA);

        if (!st.hasMoreTokens()) return;

        // Initialize _lcm = 1
        long currentLcm = 1;
        
        // Read elements from A and calculate LCM iteratively
        // _lcm = 1
        // for a in A :
        //     _lcm = _lcm * a // gcd ( _lcm , a )
        
        while (st.hasMoreTokens()) {
            long a = Long.parseLong(st.nextToken());
            // Calculate LCM iteratively: lcm(currentLcm, a)
            currentLcm = lcm(currentLcm, a);
        }

        // Calculate the sum of modular inverses: sum ( [ pow ( s , MOD - 2 , MOD ) for s in A ] )
        long sumInverses = 0;
        
        // We need to re-read A or store A if we want to calculate the sum of inverses.
        // Since we consumed the input line, we must re-read the input or store A.
        // Let's assume the input reading structure implies reading all numbers first.
        
        // Rereading input to store A for the second calculation, or restructuring the input reading.
        // Given the structure, we must assume the input reading was sequential.
        // Let's re-read the input stream logic to store A properly.
        
        // Since I cannot rewind System.in easily in this context,
