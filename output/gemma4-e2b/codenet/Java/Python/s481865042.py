import sys

def solve():
    # Read input from stdin. Assuming s and k are provided sequentially.
    try:
        # Read s (string)
        s = sys.stdin.readline().strip()
        # Read k (long)
        k_str = sys.stdin.readline().strip()
        
        if not s or not k_str:
            return
            
        k = int(k_str)
    except Exception:
        # Handle potential reading errors
        return

    sb = []
    
    for char in s:
        # Calculate index relative to 'a' (0-25)
        idx = ord(char) - ord('a')
        
        # Distance to wrap around from 'z' back to 'a