import sys
import heapq

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # The first element is N
    N = int(data[0])
    
    # The rest are the elements of array A
    A = [int(x) for x in data[1:N+1]]
    
    # Sort A
    A.sort()

    res = 0

    # Priority Queue setup: We want to prioritize elements based on min(x, y) in descending order.
    # Python's heapq is a min-heap. To simulate a max-heap based on a value, we store the negative of that value.
    # The elements stored in the queue will be [min(x, y), max(x, y)] or similar structure.
    
    # The Java code stores int[] {A[N-1], A[N-1]} initially.
    # We use a min-heap. We want to prioritize the largest min value.
    # We store (-min(x, y), x, y) to simulate a max-heap on min(x, y).
    
    # Initialize the priority queue
    # The initial element is {A[N-1], A[N-1]}
    # Since A is sorted, A[N-1] is the largest element.
    
    # We store the pair (min, max) in the heap. We want to maximize min.
    # Heap stores: (-min(x, y), x, y)
    q = []
    
    # Start with the largest element paired with itself
    # A[N-1] is the largest element
    heapq.heappush(q, (-A[N-1], A[N-1], A[N-1]))

    # Iterate from N-2 down to 0
    for i in range(N - 2, -1, -1):
        a = A[i]
        
        # Extract the element with the largest min value (smallest negative min value)
        neg_min_place, place0, place1 = heapq.heappop(q)
        
        # The actual minimum value is -neg_min_place
        min_val = -neg_min_place
        res += min_val
        
        # Add the new pair involving A[i]
        # The new pairs are {place0, a} and {a, place1}
        
        # Add {place0, a}
        new_min1 = min(place0, a)
        new_max1 = max(place0, a)
        heapq.heappush(q, (-new_min1, new_max1, new_min1))
        
        # Add {a, place1}
        new_min2 = min(a, place1)
        new_max2 = max(a, place1)
        heapq.heappush(q, (-new_min2, new_max2, new_min2))

    print(res)

solve()