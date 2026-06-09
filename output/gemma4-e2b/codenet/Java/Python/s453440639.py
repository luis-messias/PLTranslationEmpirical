import sys

def solve():
    # Read H and W
    try:
        # Read H and W from the first line
        line = sys.stdin.readline()
        if not line:
            return
        H, W = map(int, line.split())
    except EOFError:
        return
    except ValueError:
        # Handle case where input might be malformed or empty
        return

    # Read the grid S
    S = []
    for _ in range(H):
        try:
            row = sys.stdin.readline().strip()
            if not row:
                # Handle unexpected end of input if H lines were expected
                break
            S.append(list(row))
        except EOFError:
            break
    
    if len(S) != H:
        # Handle case where input reading failed partially
        return

    # Process the grid
    for i in range(H):
        for j in range(W):
            if S[i][j] == '.':
                count = 0
                # Check 8 neighbors
                for a in range(-1, 2):
                    for b in range(-1, 2):
                        if a == 0 and b == 0:
                            continue
                        
                        ni, nj = i + a, j + b
                        
                        # Check bounds
                        if 0 <= ni < H and 0 <= nj < W:
                            if S[ni][nj] == '#':
                                count += 1
                
                # Replace '.' with the character representation of (count + 48)
                # 48 is ASCII for '0'.
                S[i][j] = chr(count + 48)

    # Output the result
    for i in range(H):
        print("".join(S[i]))

solve()