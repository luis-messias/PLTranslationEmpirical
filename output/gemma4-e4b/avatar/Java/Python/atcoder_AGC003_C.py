import heapq
import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    N = int(data[0])
    
    # The values are the remaining N elements
    values = [int(x) for x in data[1:N+1]]

    # map: value -> original_index
    value_to_index = {}
    # nums: min-heap (PriorityQueue equivalent)
    nums_heap = []

    # Populate map and heap
    for i in range(N):
        val = values[i]
        value_to_index[val] = i
        heapq.heappush(nums_heap, val)

    diff = 0
    bin_parity = 0  # Tracks the parity of the processing step (0 or 1)

    # Process elements in increasing order
    while nums_heap:
        num = heapq.heappop(nums_heap)
        idx = value_to_index[num]
        
        # Check condition: (bin % 2) != (idx % 2)
        if (bin_parity % 2) != (idx % 2):
            diff += 1
        
        # Update bin_parity (toggle 0 -> 1 -> 0 -> ...)
        bin_parity = 1 - bin_parity

    # Calculate answer (integer division)
    ans = diff // 2
    print(ans)

solve()