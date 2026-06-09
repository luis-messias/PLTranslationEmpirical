import sys
from collections import Counter

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is N
    try:
        N = int(data[0])
    except ValueError:
        return

    # The values are the next N elements
    values = []
    if len(data) > 1:
        # Extract the N values
        values = [int(x) for x in data[1:N+1]]

    # Count frequencies
    counts = Counter(values)
    
    # Find max frequency
    if not counts:
        max_freq = 0
    else:
        max_freq = max(counts.values())
        
    # Calculate result: max_freq + number of unique elements (map size)
    result = max_freq + len(counts)
    
    print(result)

if __name__ == "__main__":
    solve()