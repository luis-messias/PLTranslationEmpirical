import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # Input parsing based on the Java structure
    
    # N is the first element
    n = int(data[0])
    
    # M is the second element
    m = int(data[1])
    
    # The remaining data are the M triplets (X, Y, Z)
    # The indices start from 2
    
    # Initialize UnionFindTree
    par = list(range(n))
    rank = [0] * n

    def find(x):
        if par[x] == x:
            return x
        par[x] = find(par[x])
        return par[x]

    def unite(x, y):
        root_x = find(x)
        root_y = find(y)
        if root_x != root_y:
            if rank[root_x] < rank[root_y]:
                par[root_x] = root_y
            else:
                par[root_y] = root_x
                if rank[root_x] == rank[root_y]:
                    rank[root_x] += 1

    # Process M union operations
    data_idx = 2
    for _ in range(m):
        if data_idx + 2 < len(data):
            # x = data[data_idx] - 1
            x = int(data[data_idx]) - 1
            # y = data[data_idx + 1] - 1
            y = int(data[data_idx + 1]) - 1
            # z = data[data_idx + 2] (ignored)
            # We only need x and y for the union operation
            unite(x, y)
            data_idx += 3
        else:
            # Handle case where input might be truncated, though unlikely in competitive programming context
            break

    # Count the number of disjoint sets (roots)
    cnt = 0
    for i in range(n):
        if par[i] == i:
            cnt += 1
            
    print(cnt)

solve()