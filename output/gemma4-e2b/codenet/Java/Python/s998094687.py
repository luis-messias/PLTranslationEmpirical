import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        n = int(data[0])
    except ValueError:
        # Handle case where the first token is not an integer
        return

    data_ptr = 1
    
    for _ in range(n):
        if data_ptr + 2 >= len(data):
            break
            
        try: