import heapq
import sys

def main():
    # Read all input tokens from standard input
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is n
    n = int(data[0])
    
    # The remaining n elements are the numbers
    numbers = [int(x) for x in data[1:n+1]]
    
    # Initialize the min-heap
    queue = numbers[:]
    heapq.heapify(queue)
    
    sum_val = 0
    
    # Poll the smallest n-1 elements
    for _ in range(n - 1):
        # heapq.heappop retrieves and removes the smallest item
        sum_val += heapq.heappop(queue)
        
    # The last element remaining is polled
    last_element = heapq.heappop(queue)
    
    # Output comparison
    if last_element < sum_val:
        print("Yes")
    else:
        print("No")

if __name__ == "__main__":
    main()