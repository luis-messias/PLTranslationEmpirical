import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is N
    try:
        n = int(data[0])
    except ValueError:
        # Handle case where N is not an integer
        return

    # The remaining elements are the pairs (l, r)
    # data[1:] contains all the numbers for l and r
    
    total_sum = 0
    
    # We iterate n times, processing two elements (l and r) each time
    for i in range(n):
        # Index for l[i] is 1 + 2*i
        l_i = int(data[1 + 2 * i])
        # Index for r[i] is 2 + 2*i
        r_i = int(data[2 + 2 * i])
        
        # Calculate the length of the range [l_i, r_i]
        total_sum += r_i - l_i + 1
        
    print(total_sum)

solve()