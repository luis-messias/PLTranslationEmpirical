import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    if not data:
        return

    ptr = 0
    
    # N
    N = int(data[ptr])
    ptr += 1
    
    # M
    M = int(data[ptr])
    ptr += 1
    
    # H array
    H = [int(data[ptr + i]) for i in range(N)]
    ptr += N
    
    # Queries
    queries = []
    for _ in range(M):
        temp1 = int(data[ptr])
        temp2 = int(data[ptr + 1])
        queries.append((temp1, temp2))
        ptr += 2
        
    # Initialize answer array (True means potentially valid)
    ans = [True] * N
    
    # Process queries
    for temp1, temp2 in queries:
        # Convert 1-based input indices to 0-based list indices
        idx1 = temp1 - 1
        idx2 = temp2 - 1
        
        h1 = H[idx1]
        h2 = H[idx2]
        
        if h1 < h2:
            # H[temp1] < H[temp2] => ans[temp1] = false
            ans[idx1] = False
        elif h1 > h2:
            # H[temp1] > H[temp2] => ans[temp2] = false
            ans[idx2] = False
        else: # h1 == h2
            # ans[temp1] = false, ans[temp2] = false
            ans[idx1] = False
            ans[idx2] = False
            
    # Count the number of True values remaining
    ans2 = sum(ans)
    
    print(ans2)

solve()