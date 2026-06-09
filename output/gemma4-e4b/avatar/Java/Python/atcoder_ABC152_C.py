import heapq
import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return 0
    
    # The first element is N
    try:
        N = int(data[0])
    except IndexError:
        return 0

    # The remaining elements are the array values
    arr = [int(x) for x in data[1:N+1]]
    
    sum_count = 0
    min_heap = []
    
    for x in arr:
        # Add x to the min-heap
        heapq.heappush(min_heap, x)
        
        # Check if x <= min_heap[0] (min_heap[0] is the peek equivalent)
        if x <= min_heap[0]:
            sum_count += 1
            
    return sum_count

if __name__ == "__main__":
    print(solve())