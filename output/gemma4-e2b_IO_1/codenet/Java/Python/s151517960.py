import sys
from collections import Counter

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # The first token is N
        n = int(data[0])
        
        if len(data) < n + 1:
            # Not enough numbers provided
            return
            
        # The next N tokens are the numbers to count
        numbers = [int(x) for x in data[1:n+1]]
        
        # Calculate frequencies
        counts = Counter(numbers)
        
        # Count how many frequencies are odd
        ans = 0
        for count in counts.values():
            if count % 2 == 1:
                ans += 1
                
        print(ans)
        
    except ValueError:
        # Handle case where input tokens are not valid integers
        return

solve()
