import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The input format is K and S
    try:
        K = int(data[0])
        S = int(data[1])
    except IndexError:
        # Handle case where input might be incomplete
        return
    except ValueError:
        # Handle case where input is not valid integers
        return

    # The problem asks for the number of non-negative integer solutions (X, Y)
    # such that:
    # 1. 0 <= X <= K
    # 2. 0 <= Y <= K
    # 3. 0 <= Z <= K, where Z = S - X - Y
    # This means: 0 <= S - X - Y <= K
    # S - K <= X + Y <= S
    
    # We iterate over X and Y within their bounds [0, K]
    ans = 0
    for x in range(K + 1):
        for y in range(K + 1):
            z = S - x - y
            # Check if Z satisfies 0 <= Z <= K
            if 0 <= z <= K:
                ans += 1
    
    print(ans)

if __name__ == "__main__":
    solve()