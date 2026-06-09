import java.util.Scanner;
import java.lang.Math;

public class s242961129 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();

        // Read array A
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextInt()) return;
            A[i] = scanner.nextInt();
        }

        // Step 3: ans = abs(A[-1])
        // A[-1] is A[N-1] in 0-indexing
        long ans = Math.abs(A[N - 1]);

        // Step 4: A=[0]+A+[0]
        // We need an extended array for easier indexing matching the Python logic.
        // A_ext will have size N+2
        int[] A_ext = new int[N + 2];
        A_ext[0] = 0;
        for (int i = 0; i < N; i++) {
            A_ext[i + 1] = A[i];
        }
        A_ext[N + 1] = 0;

        // Step 5: diff=[0 for x in range(N)]
        long[] diff = new long[N];

        // Step 6: Loop for i from 1 to N
        for (int i = 1; i <= N; i++) {
            // Python uses A[i] and A[i-1] based on the extended list A.
            // In Java, A_ext has indices 0 to N+1.
            // The Python loop uses A[i] and A[i+1] which correspond to A_ext[i] and A_ext[i+1] if we map i=1..N to the loop index.
            
            // Let's map Python's A[i] to A_ext[i] for i=1..N.
            // Python A[i] corresponds to A_ext[i]
            // Python A[i-1] corresponds to A_ext[i-1]
            // Python A[i+1] corresponds to A_ext[i+1]

            int Ai = A_ext[i];
            int Ai_minus_1 = A_ext[i - 1];
            int Ai_plus_1 = A_ext[i + 1];

            // dif=abs(A[i]-A[i-1])+abs(A[i]-A[i+1])-abs(A[i-1]-A[i+1])
            long dif = Math.abs(Ai - Ai_minus_1) + Math.abs(Ai - Ai_plus_1) - Math.abs(Ai_minus_1 - Ai_plus_1);
            
            // ans+=abs(A[i]-A[i-1])
            ans += Math.abs(Ai - Ai_minus_1);
            
            // diff[i-1]=dif
            // Since i runs from 1 to N, i-1 runs from 0 to N-1.
            diff[i - 1] = dif;
        }

        // Final output loop
        // for i in range(N): print(ans-diff[i])
        for (int i = 0; i < N; i++) {
            System.out.println(ans - diff[i