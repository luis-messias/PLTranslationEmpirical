import sys

def solve():
    # Read all tokens from standard input
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        
        str_val = data[0]
        k = int(data[1])
    except Exception:
        # Handle potential reading errors
        return

    # Iterate from i = 0 up to k-1
    for i in range(k):
        char_at_i = str_val[i]
        
        if char_at_i == '1':
            # Case 1: Character is '1'
            if i == k - 1:
                # If it's the last index checked
                print(1)
                return
        else:
            # Case 2: Character is not '1'
            print(char_at_i)
            return

if __name__ == "__main__":
    solve()