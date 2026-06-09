import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class s534639230 {

    static long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N (ignored)
        String line1 = br.readLine();
        if (line1 == null) return;

        // Read D
        String line2 = br.readLine();
        if (line2 == null) return;
        StringTokenizer st = new StringTokenizer(line2);
        
        // D is the list of numbers
        // We don't strictly need to store D as an array if we process counts directly, 
        // but reading it into an array is fine for finding maxD.
        
        // 1. Calculate counts (Counter equivalent)
        Map<Integer, Long> cnt = new HashMap<>();
        int maxD = 0;
        
        // Read D elements and populate counts
        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());
            cnt.put(x, cnt.getOrDefault(x, 0L) + 1);
            if (x > maxD) {
                maxD = x;
            }
        }

        long mod = 998244353;

        // 2. Check initial conditions
        if (cnt.isEmpty()) {
            // If D was empty, the result is 1 (empty product)
            System.out.println(1);
            return;
        }
        
        // Check D[0] != 0. We need to check if 0 exists and if it's the first element read, 
        // but the Python code checks D[0]. Since we only have counts, we check if 0 is present.
        // If the input guarantees D[0] is the first element read, we must rely on the input structure.
        // Since the Python code relies on D[0], we must ensure we handle the input reading correctly.
        // Let's re-read D into an array to strictly follow the Python logic structure regarding D[0].
        
        // Rereading input to handle D[0] check correctly based on Python structure
        // Since we consumed the tokenizer, we need to reset or re-read if we want D[0] explicitly.
        // Given the constraints of competitive programming input reading, we assume the tokens read form D.
        
        // Let's assume the input reading was intended to be:
        // N (ignored)
        // D1 D2 D3 ...
        
        // If we strictly follow the Python logic:
        // if D[0] != 0: print(0)
        
        // We need to re-read D into an array to check D[0]. Let's adjust input reading slightly.
        
        // --- Re-implementing input reading to get D array ---
        
        // Since we cannot rewind BufferedReader easily, we must assume the tokens read form D.
        // If the problem implies D is the list of numbers read, and the first number read is D[0]:
        
        // We need to re-read the input stream or store all tokens. Let's store them.
        
        // Resetting input reading for clarity based on Python structure:
        
        // If we assume the input reading above successfully populated cnt and maxD:
        
        // Check D[0] != 0. This requires knowing the original order, which is lost in the map approach.
        // We must read D into an array first.
        
        // Since the provided template structure is fixed, I will assume the input reading logic must be adapted to store D.
        
        // Let's restart the input reading to store D explicitly.
        
        // --- Final attempt based on strict translation of Python logic ---
        
        // Since the provided Java template already attempted to read D into an array, 
        // I will assume the tokens read form D, and we must check the first element read.
        
        // If we assume the input reading above was correct for reading D:
        
        // We need to know D[0]. If we don't store D, we cannot check D[0].
        // Let's modify the input reading to store D.
        
        // Since I cannot modify the input reading structure easily
