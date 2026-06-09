import sys
import collections

# Set recursion limit higher for deep DFS calls
sys.setrecursionlimit(2000)

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    if not data:
        return

    # FastScanner equivalent setup
    data_ptr = 0
    def next_int():
        nonlocal data_ptr
        val = int(data[data_ptr])
        data_ptr += 1
        return val

    # Read N and Q
    if data_ptr < 2:
        return
    
    n = next_int()
    q = next_int()

    # Initialize graph (Adjacency List)
    graph = [[] for _ in range(n)]

    # Read N-1 edges
    for _ in range(n - 1):
        if data_ptr + 1 >= len(data):
            break
        u = next_int() - 1
        v = next_int() - 1
        graph[u].append(v)
        graph[v].append(u)

    # Initialize counter array
    counter = [0] * n

    # Read Q queries
    for _ in range(q):
        if data_ptr + 1 >= len(data):
            break
        # The query value is read and added to the counter
        query_val = next_int()
        # The Java code does: counter[fs.nextInt()-1]+=fs.nextInt();
        # This implies the query value itself is added to the counter, not just the next number.
        # Based on the structure: counter[fs.nextInt()-1]+=fs.nextInt();
        # The input stream provides N, Q, then N-1 pairs of edges, then Q pairs of values.
        # Let's re-examine the input reading based on the Java structure:
        # N, Q
        # N-1 pairs of (a, b)
        # Q pairs of (value)
        
        # If the input stream is flat: N, Q, a1, b1, a2, b2, ..., a_{n-1}, b_{n-1}, q1, q2, ..., q_q
        # The Java code reads:
        # for(int i=0;i<n-1;i++){ a = fs.nextInt()-1; b = fs.nextInt()-1; ... } (Reads 2*(n-1) numbers)
        # for(int i=0;i<q;i++){ counter[fs.nextInt()-1]+=fs.nextInt(); } (Reads 2*q numbers)
        
        # This implies the input stream contains all edge endpoints and all query values sequentially.
        
        # Let's re-read the input based on the structure implied by the Java code's reading pattern:
        # The input stream contains N, Q, followed by 2*(N-1) edge endpoints, followed by 2*Q query values.
        
        # Since we read N and Q already, the remaining numbers are the edges and queries.
        
        # We need to adjust the reading logic if we assume the input stream is flat.
        # Let's restart the reading assuming the input is flat and sequential.
        pass # We will handle the reading based on the flat list 'data' below.

    # --- Re-implementing input reading based on flat list 'data' ---
    
    data_ptr = 0
    
    if not data:
        return
        
    n = int(data[data_ptr])
    data_ptr += 1
    q = int(data[data_ptr])
    data_ptr += 1

    graph = [[] for _ in range(n)]
    
    # Read edges (N-1 pairs)
    for _ in range(n - 1):
        if data_ptr + 1 >= len(data): break
        u = int(data[data_ptr]) - 1
        v = int(data[data_ptr+1]) - 1
        data_ptr += 2
        graph[u].append(v)
        graph[v].append(u)

    counter = [0] * n

    # Read queries (Q pairs)
    for _ in range(q):
        if data_ptr + 1 >= len(data): break
        # The Java code reads: counter[fs.nextInt()-1]+=fs.nextInt();
        # This means it reads two numbers per query iteration.
        # The first number is the index, the second is the value to add.
        idx = int(data[data_ptr]) - 1
        value = int(data[data_ptr+1])
        data_ptr += 2
        counter[idx] += value


    # DFS function
    def dfs(v, par, val):
        # This function modifies the global 'counter' array implicitly via scope if it were a class method, 
        # but since it's a standalone function, we need to pass/modify it if we want side effects.
        # In Python, we modify the list directly if we treat it as mutable state.
        
        for i in graph[v]:
            if i != par:
                dfs(i, v, val)
        
        # The update happens after visiting all children
        counter[v] += val

    # Start DFS from node 0
    dfs(0, -1, 0)

    # Output result