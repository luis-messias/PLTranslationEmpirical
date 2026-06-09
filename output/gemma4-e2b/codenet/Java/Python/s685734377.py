import sys

def solve():
    # Fast input reading
    input = sys.stdin.read().split()
    
    if not input:
        return

    # The input reading needs to handle reading N, then N*N characters.
    # Since the Java code uses FastScanner to read tokens sequentially, 
    # we process the input list.
    
    # N is the first token
    try:
        n = int(input[0])
    except ValueError:
        # Handle case where input might be empty or malformed initially
        return

    if n == 0:
        print(0)
        return

    # Read the matrix A (n x n characters)
    # The remaining tokens are the characters of the matrix.
    a = []
    input_idx = 1
    for i in range(n):
        row = list(input[input_idx : input_idx + n])
        a.append(row)
        input_idx += n

    P = 37
    Q = 47

    # Precalculate powers of P and Q
    powP = [1] * (n + 1)
    powQ = [1] * (n + 1)
    for i in range(1, n + 1):
        powP[i] = powP[i - 1] * P
        powQ[i] = powQ[i - 1] * Q

    # --- Hashing ---
    hashRow = [[0] * n for _ in range(n)]
    hashCol = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            # a[i][j] is a character, we use its ASCII value for multiplication, 
            # matching how Java handles char multiplication.
            val = ord(a[i][j])
            
            # hashRow[i][k] += a[i][j] * powP[(j - k + n) % n];
            for k in range(n):
                # Term for hashRow: a[i][j] * P^((j - k + n) % n)
                exponent = (j - k + n) % n
                hashRow[i][k] += val * powP[exponent]
                
                # Term for hashCol: a[i][j] * P^((i - k + n) % n)
                # Note: The Java code uses powP for both hashRow and hashCol calculation.
                # hashCol[j][k] += a[i][j] * powP[(i - k + n) % n]; 
                # Wait, the Java code uses a[i][j] for both hashRow and hashCol calculation, 
                # but the second term uses powP. Let's re-examine the Java loop structure carefully.

    # Re-implementing the hash calculation exactly as in Java:
    # Java:
    # for (int i = 0; i < n; i++) {
    #     for (int j = 0; j < n; j++) {
    #         for (int k = 0; k < n; k++) {
    #             hashRow[i][k] += a[i][j] * powP[(j - k + n) % n];
    #             hashCol[j][k] += a[i][j] * powP[(i - k + n) % n];
    #         }
    #     }
    # }
    
    hashRow = [[0] * n for _ in range(n)]
    hashCol = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            val = ord(a[i][j])
            for k in range(n):
                # hashRow[i][