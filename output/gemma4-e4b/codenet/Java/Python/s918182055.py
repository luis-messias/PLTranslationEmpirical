import heapq
import sys

def solve():
    # Fast input reading
    input = sys.stdin.read
    data = input().split()
    
    if not data:
        return

    # N: number of pairs, M: maximum index
    N = int(data[0])
    M = int(data[1])
    
    # Pointer for reading data array
    data_ptr = 2
    
    # list_map: stores {a: [b1, b2, ...]}
    list_map = {}
    
    # Read N pairs (a, b)
    for _ in range(N):
        a = int(data[data_ptr])
        b = int(data[data_ptr + 1])
        data_ptr += 2
        
        if a not in list_map:
            list_map[a] = []
        list_map[a].append(b)
        
    # Max-Heap implementation using Python's min-heap (heapq)
    # We store negative values to simulate a max-heap
    pqueue = []
    
    res = 0
    
    # Iterate from i = 1 to M
    for i in range(1, M + 1):
        if i in list_map:
            # Add all values associated with index i to the heap
            for b in list_map[i]:
                # Push negative value to simulate max-heap
                heapq.heappush(pqueue, -b)
        
        # If the heap is not empty, pop the maximum value
        if pqueue:
            # Pop the smallest negative number (which corresponds to the largest positive number)
            max_val_neg = heapq.heappop(pqueue)
            res += (-max_val_neg)
            
    print(res)

if __name__ == "__main__":
    solve()