import sys
from collections import Counter

def solve():
    # Read N and K
    try:
        line = sys.stdin.readline().split()
        if not line:
            return
        N = int(line[0])
        K = int(line[1])
    except EOFError:
        return
    except IndexError:
        # Handle case where only N is provided, though unlikely based on problem constraints
        return

    # Read string S
    S = sys.stdin.readline().strip()

    # Calculate initial counts for 'A' through 'Z'
    counts = [0] * 26
    for char in S:
        index = ord(char) - ord('A')
        counts[index] += 1

    ans = 0
    i = 0
    
    # The loop runs as long as we haven't processed K steps
    while i < K:
        # Sort the counts to easily find the maximum count
        # We must sort a copy or re-sort the list in place
        counts.sort()
        
        # The maximum count is the last element
        max_count = counts[-1]
        
        # Determine how many steps (change) we can take
        # Limited by the current max count and remaining steps (K - i)
        change = min(max_count, K - i)
        
        # Update the answer
        ans += change * change
        
        # Decrease the count of the most frequent card
        counts[-1] -= change
        
        # Advance the step counter i by the number of steps taken
        i += change

    print(ans)

if __name__ == "__main__":
    solve()