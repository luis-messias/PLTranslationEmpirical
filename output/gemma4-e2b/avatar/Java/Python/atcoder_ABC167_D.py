import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # Scanner equivalent setup
    data_ptr = 0
    
    # N
    N = int(data[data_ptr])
    data_ptr += 1
    
    # K
    K = int(data[data_ptr])
    data_ptr += 1
    
    # A array (N elements)
    A = []
    for _ in range(N):
        A.append(int(data[data_ptr]))
        data_ptr += 1

    # Initialization based on Java logic
    used = set()
    idx = [0] * N  # Stores the step count (cur) when index i was visited
    pos = [0] * N  # Stores the index visited at step cur
    
    next_