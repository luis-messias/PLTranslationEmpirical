import sys

def solve():
    # Read all inputs from stdin
    try:
        data = sys.stdin.read().split()
        if len(data) < 5:
            return
        
        Q = int(data[0])
        H = int(data[1])
        S = int(data[2])
        D = int(data[3])
        N = int(data[4])

        # Calculate onePrice
        onePrice = min(Q * 4, H * 2, S)

        # Conditional logic
        # Comparison: onePrice <= D / 2
        if onePrice <= D / 2:
            # N * onePrice
            print(N * onePrice)
        else:
            # (N / 2) * D + (N % 2) * onePrice
            # Using integer division (//) for N/2, matching Java's behavior for long division.
            result = (N // 2) * D + (N % 2) * onePrice
            print(result)
            
    except Exception:
        # Handle potential errors during input processing
        pass

solve()