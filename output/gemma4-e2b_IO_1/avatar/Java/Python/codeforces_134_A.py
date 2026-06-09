import sys

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        N = int(data[0])
        if N == 0:
            print(0)
            return
            
        # The array elements start from index 1
