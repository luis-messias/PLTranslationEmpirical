import sys
from collections import Counter

def solve():
    # Read N
    try:
        n_line = sys.stdin.readline()
        if not n_line:
            return
        n = int(n_line.strip())
    except EOFError:
        return
    except ValueError:
        # Handle case where N might not be provided correctly
        return

    # Read the list of numbers
    try:
        data_line = sys.stdin.readline()
        if not data_line:
            # If N was read but data line is missing
            if n > 0:
                print(0)
            return
        
        data = list(map(int, data_line.split()))
    except EOFError:
        data = []
    except ValueError:
        data = []

    # Calculate frequencies
    hm = Counter(data)
    
    ans = 0
    
    # Iterate through unique values (keys)
    for val, num in hm.items():
        # val is the key (the number itself)
        # num is the frequency (the count)
        
        if num > val:
            ans += num - val
        elif num < val:
            ans += num
            
    print(ans)

if __name__ == "__main__":
    solve()