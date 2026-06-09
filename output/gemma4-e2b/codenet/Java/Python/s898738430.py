import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is n
    n = int(data[0])
    
    # The rest are the elements of array a
    if len(data) < n + 1:
        # Handle case where input might be incomplete
        return
        
    a = [int