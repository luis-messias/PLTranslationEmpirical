import sys

def solve():
    # Read input from stdin
    try:
        # Read N, K, S from the input stream
        data = sys.stdin.read().split()
        if len(data) < 3:
            return
        
        N = int(data[0])
        K = int(data[1])
        S = data[2]
    except Exception:
        # Handle potential empty input or parsing errors gracefully if running interactively
        return

    # Convert S to a mutable list of characters for transformations
    c1 = list(S)
    c3 = list(S)

    # --- Transformation for c1 ---
    flag = False
    count = 0
    for i in range(N):
        if flag and c1[i] == 'R':
            flag = False
            count += 1
        
        if count == K:
            break
        
        if c1[i] == 'L':
            flag = True
            c1[i] = 'R'

    # --- Transformation for c3 ---
    flag = False
    count = 0
    for i in range(N):
        if flag and c3[i] == 'L':
            flag = False
            count += 1
        
        if count == K:
            break
        
        if c3[i] == 'R':
            flag = True
            c3[i] = 'L'

    S1 = "".join(c1)
    S3 = "".join(c3)

    # --- Calculate sum1 based on S1 ---
    if N ==