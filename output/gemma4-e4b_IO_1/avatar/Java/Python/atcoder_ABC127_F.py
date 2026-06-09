import sys
import heapq

def solve():
    # Read all input data efficiently
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first element is the number of test cases t
    try:
        t = int(input_data[0])
    except IndexError:
        return

    # Initialize data structures
    # pqmax: Min-heap (stores positive values)
    pqmax = []
    # pqmin: Max-heap (stores negative values to simulate max-heap behavior)
    pqmin = []
    
    sumMin = 0
    sumMax = 0
    sumb = 0
    min_val = 0
    
    data_index = 1
    
    for _ in range(t):
        # Check if we have enough data for a test case
        if data_index + 2 >= len(input_data):
            break
            
        s0 = input_data[data_index]
        s1 = input_data[data_index + 1]
        s2 = input_data[data_index + 2]
        data_index += 3
        
        # Check if it's a query ('2')
        if s0[0] == '2':
            # Query calculation
            
            # ans = min * pqmin.size() - sumMin
            ans = min_val * len(pqmin) - sumMin
            
            # ans1 = sumMax - min * pqmax.size()
            ans1 = sumMax - min_val * len(pqmax)
            
            result = f"{min_val} {ans + ans1 + sumb}"
            print(result)
        else:
            # Update operation
            try:
                in_val = int(s1)
                sumb += int(s2)
            except ValueError:
                # Handle potential parsing errors if input format is unexpected
                continue
            
            # Insertion
            if in_val > min_val:
                # Add to max side (pqmax)
                heapq.heappush(pqmax, in_val)
                sumMax += in_val
            else:
                # Add to min side (pqmin)
                # Store negative value for max-heap behavior
                heapq.heappush(pqmin, -in_val)
                sumMin += in_val
            
            # Balancing
            
            # If pqmin size > pqmax size: Move largest element from pqmin to pqmax
            if len(pqmin) > len(pqmax):
                # Largest element in pqmin (max-heap) is -pqmin[0]
                val_to_move = -pqmin[0]
                
                # Update sums
                sumMax += val_to_move
                sumMin -= val_to_move
                
                # Move element
                heapq.heappop(pqmin)
                heapq.heappush(pqmax, val_to_move)
            
            # If pqmin size < pqmax size: Move smallest element from pqmax to pqmin
            elif len(pqmin) < len(pqmax):
                # Smallest element in pqmax (min-heap)
                val_to_move = heapq.heappop(pqmax)
                
                # Update sums
                sumMax -= val_to_move
                sumMin += val_to_move
                
                # Move element (store negative)
                heapq.heappush(pqmin, -val_to_move)
            
            # Update min_val (peek from pqmin, which is the max-heap)
            if pq
