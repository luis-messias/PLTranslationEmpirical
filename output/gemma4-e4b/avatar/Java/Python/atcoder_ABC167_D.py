import sys

def solve():
    # Read all input tokens
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # Pointer for reading tokens
    data_ptr = 0

    # N (int), K (long)
    N = int(input_data[data_ptr])
    K = int(input_data[data_ptr + 1])
    data_ptr += 2

    # A array (0-indexed targets)
    A = []
    for _ in range(N):
        # Java reads A[i] - 1, so we store the 0-indexed target directly
        A.append(int(input_data[data_ptr]) - 1)
        data_ptr += 1

    # Initialization
    used = set()
    # idx[i] = j means index i was reached at step j
    idx = [0] * N
    # pos[j] = i means the node visited at step j was index i
    pos = [0] * N

    next_node = 0
    cur = 0

    # Cycle Detection Loop
    while next_node not in used:
        used.add(next_node)
        
        # Store current step (cur) at the node (next_node)
        idx[next_node] = cur
        
        # Store the node visited at step (cur)
        pos[cur] = next_node
        
        # Move to the next node
        next_node = A[next_node]
        cur += 1

    # Cycle detected.
    # next_node is the start of the cycle.
    # cur is the length of the path up to the node *before* the cycle repeats.
    
    # a = length of the cycle
    a = cur - idx[next_node]
    # b = length of the path from start to cycle start
    b = idx[next_node]

    # Calculate ans: ( (10000 * a + K - b) % a + b )
    # Since 10