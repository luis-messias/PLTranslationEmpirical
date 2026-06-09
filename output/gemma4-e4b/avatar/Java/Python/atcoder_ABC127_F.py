import sys
import heapq

def solve():
    # Fast input reading
    input = sys.stdin.read
    data = input().split()
    
    if not data:
        return

    # The first element is the number of test cases t
    t = int(data[0])
    
    # Initialize data structures
    # pqmax: Min-heap (stores actual values)
    pqmax = []
    # pqmin: Max-heap (stores negative values to simulate max-heap behavior)
    pqmin = []
    
    sumMin = 0
    sumMax = 0
    sumb = 0
    min_val = 0
    
    data_index = 1
    
    for _ in range(t):
        # Read the line components
        s0 = data[data_index]
        s1 = data[data_index + 1]
        s2 = data[data_index + 2]
        data_index += 3
        
        # Check if it's a query ('2')
        if s0[0] == '2':
            # Query calculation
            
            # ans = min * pqmin.size() - sumMin
            ans = min_val * len(pqmin) - sumMin
            
            # ans1 = sumMax - min * pqmax.size()
            ans1 = sumMax - min_val * len(pqmax)
            
            result = min_val + " " + str(ans + ans1 + sumb)
            print(result)
        else:
            # Update operation
            in_val = int(s1)
            sumb += int(s2)
            
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
            
            # If pqmin size > pqmax size: Move smallest element from pqmin to pqmax
            if len(pqmin) > len(pqmax):
                # Peek/Poll from pqmin (max-heap)
                # The actual value is -pqmin[0]
                val_to_move = -pqmin[0]
                
                # Update sums
                sumMax += val_to_move
                sumMin -= val_to_move
                
                # Move element
                heapq.heappop(pqmin)
                heapq.heappush(pqmax, val_to_move)
            
            # If pqmin size < pqmax size: Move largest element from pqmax to pqmin
            elif len(pqmin) < len(pqmax):
                # Peek/Poll from pqmax (min-heap)
                val_to_move = heapq.heappop(pqmax)
                
                # Update sums
                sumMax -= val_to_move
                sumMin += val_to_move
                
                # Move element (store negative)
                heapq.heappush(pqmin, -val_to_move)
            
            # Update min_val (peek from pqmin, which is the max-heap)
            if pqmin:
                min_val = -pqmin[0]
            # Note: If pqmin is empty, min_val remains 0 (or whatever initial value was set)

if __name__ ==