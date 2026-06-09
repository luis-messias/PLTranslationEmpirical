import sys
import heapq

def solve():
    # Fast input reading equivalent
    try:
        data = sys.stdin.read().split()
    except:
        # Handle empty input case if running in certain environments
        return

    if not data:
        return

    # The input format suggests N is read first, then N elements of A.
    try:
        N = int(data[0])
        A = [int(x) for x in data[1:N+1]]
    except IndexError:
        # Handle case where input might be incomplete
        return

    # Sort A
    A.sort()

    res = 0

    # Python's heapq is a min-heap.
    # We need a Max-Heap based on min(a, b).
    # We store (-min(a, b), a, b) to simulate a Max-Heap on min(a, b).
    # The heap stores tuples: (negative_min_value, a, b)
    
    # Initial pair: (A[N-1], A[N-1])
    a_max = A[N - 1]
    initial_min = min(a_max, a_max)
    
    # Heap stores (priority_key, a, b)
    q = []
    heapq.heappush(q, (-initial_min, a_max, a_max))

    # Iterate from N-2 down to 0
    for i in range(N - 2, -1, -1):
        a = A[i]
        
        # Pop the element with the largest min(a, b) (smallest negative key)
        neg_min, p0, p1 = heapq.heappop(q)
        
        # The actual minimum value is -neg_min
        current_min = -neg_min
        res += current_min
        
        # Add two new pairs to the heap
        
        # New pair 1: (p0, a)
        new_min1 = min(p0, a)
        heapq.heappush(q, (-new_min1, p0, a))
        
        # New pair 2: (a, p1)
        new_min2 = min(a, p1)
        heapq.heappush(q, (-new_min2, a, p1))

    print(res)

if __name__ == "__main__":
    # The original Java code structure suggests calling the logic once.
    solve()