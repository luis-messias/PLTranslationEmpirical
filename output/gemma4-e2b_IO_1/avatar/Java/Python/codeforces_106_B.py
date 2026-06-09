import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first element
    n = int(data[0])
    
    # The remaining elements are the coordinates
    if len(data) < n * 4:
        # Handle case where input might be incomplete, though unlikely in CP context
        return

    # Reconstruct the vector
