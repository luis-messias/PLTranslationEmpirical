import heapq

def main():
    n = int(input())
    priority_queue = []
    
    for _ in range(n):
        num = int(input())
        heapq.heappush(priority_queue, -num)
        
    sum_of_elements = 0
    
    while len(priority_queue) > 1:
        smallest_element = -heapq.heappop(priority_queue)
        if smallest_element <= sum_of_elements:
            print("Yes")
            return
        else:
            sum_of_elements += smallest_element
            
    largest_element = heapq.heappop(priority_queue)
    
    # Output the result after processing all elements except one.
    final_sum_without_largest = -sum(heapq._heappop_heapify(priority_queue))
    if final_sum_without_largest < largest_element or (final_sum_without_largest == largest_element and len(priority_queue) > 1):
        print("Yes")
    else:
        print("No")

if __name__ == "__main__":
    main()