import sys

def solve():
    # Read all input tokens
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    try:
        n = int(input_data[0])
    except ValueError:
        return

    if n == 0:
        print(0)
        return

    # Read the matrix A (n x n characters)
    a = []
    input_idx = 1
    
    # Check if enough tokens exist for the matrix
    if len(input_data) < 1 + n * n:
        # Input is incomplete
        return

    for i in range(n):
        row = []
        for j in range(n):
            # Read characters sequentially
            if input_idx < len(input_data):
                row.append(input_data[input_idx])
                input_idx += 1
            else:
                # Should not happen if input is well-formed
                return
        a.append(row)

    P = 37
    Q = 47

    # Precalculate powers of P
    powP = [1] * (n + 1)
    for i in range(1, n + 1):
        powP[i] = powP[i - 1] * P

    # --- Hashing ---
    hashRow = [[0] * n for _ in range(n)]
    hashCol = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            val = ord(a[i][j])
            
            for k in range(n):
                # hashRow[i][k] += a[i][j] * powP[(j - k + n) % n];
                exponent_row = (j - k + n) % n
                hashRow[i][k] += val * powP[exponent_row]
                
                # hashCol[j][k] += a[i][j] * powP[(i - k + n) % n];
                exponent_col = (i - k + n) % n
                hashCol[j][k] += val * powP[exponent_col]

    # --- Final Count ---
    ans = 0
    for A in range(n):
        for B in range(n):
            ok = True
            for i in range(n):
                # Check: hashRow[(i + A) % n][B] == hashCol[(i + B) % n][A]
                row_idx = (i + A) % n
                col_idx = (i + B) % n
                
                if hashRow[row_idx][B] != hashCol[col_idx][A]:
                    ok = False
                    break
            
            if ok:
                ans += 1
                
    print(ans)

solve()
