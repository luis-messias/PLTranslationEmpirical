import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    data_ptr = 0
    
    # Read N
    n = int(data[data_ptr])
    data_ptr += 1
    
    # Read M
    m = int(data[data_ptr])
    data_ptr += 1
    
    # Read req array (N elements)
    req = [int(x) for x in data[data_ptr : data_ptr + n]]
    data_ptr += n
    
    # Read pre array (M elements)
    pre = [int(x) for x in data[data_ptr : data_ptr + m]]
    
    # Simulation of the Java logic
    i = n - 1
    j = m - 1
    ans = 0
    
    while i >= 0 and j >= 0:
        if req[i] > pre[j]:
            ans += 1
        else:
            j -= 1
        
        i -= 1
        
    print(ans + i + 1)

solve()