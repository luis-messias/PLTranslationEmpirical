import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # Input parsing
    try:
        N = int(data[0])
        M = int(data[1])
    except IndexError:
        return

    # Initialize the black grid (N+2 x N+2)
    # Initialize with 0s, matching Java's default initialization for int arrays
    black = [[0] * (N + 2) for _ in range(N + 2)]
    
    data_idx = 2
    
    for m in range(1, M + 1):
        if data_idx + 1 >= len(data):
            break
            
        x = int(data[data_idx])
        y = int(data[data_idx + 1])
        data_idx += 2
        
        # Check the 3x3 neighborhood around (x, y)
        # Note: Java uses 1-based indexing implicitly for coordinates if they refer to grid positions, 
        # but here we follow the direct translation of the loop bounds.
        
        for xx in range(x - 1, x + 2):
            for yy in range(y - 1, y + 2):
                # Check bounds just in case, although the Java code relies on N+2 size
                if 0 <= xx < N + 2 and 0 <= yy < N + 2:
                    # Equivalent to ++ black[xx][yy] == 9
                    # We increment the value and check if the new value is 9
                    black[xx][yy] += 1
                    if black[xx][yy] == 9:
                        print(m)
                        return

    # If loop finishes without finding 9
    print("-1")

solve()