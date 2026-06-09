import sys
import io

# Set up input reading similar to the Java MyScanner
def solve():
    # Read all input from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # Input reading pointer
    data_ptr = 0
    
    def next_int():
        nonlocal data_ptr
        val = int(input_data[data_ptr])
        data_ptr += 1
        return val

    # Read N
    try:
        n = next_int()
    except IndexError:
        return

    # Initialize adjacency list g
    g = [[] for _ in range(n)]

    # Read N-1 edges
    for _ in range(n - 1):
        try:
            u = next_int() - 1
            v = next_int() - 1
            g[u].append(v)
            g[v].append(u)
        except IndexError:
            # Handle case where input might end prematurely
            break

    # The maxMatching function (recursive)
    # Note: The Java implementation uses static fields and recursion.
    # We define it as a helper function or method.
    
    # We need to handle the fact that the Java code calls maxMatching(0, -1).
    # The logic seems to rely on the structure of the graph and the specific recursive definition.
    
    # Since the Java code uses a static method and relies on the global state g, 
    # we define the recursive function to operate on the graph structure.
    
    # maxMatching(v, p)
    def maxMatching(v, p):
        a = 0
        o = 0
        
        # Iterate over neighbors w of v
        for w in g[v]:
            if w == p:
                continue
            
            # Recursive call
            r = maxMatching(w, v)
            
            # Accumulate results based on Java logic
            a += r // 2  # Integer division for r / 2
            o += r % 2   # Remainder for r % 2
            
        # Return value based on Java logic: 2 * a + Math.min(1, o) + 1
        return 2 * a + min(1, o) + 1

    # Calculate m = maxMatching(0, -1) / 2
    # The initial call is maxMatching(0, -1)
    result = maxMatching(0, -1)
    
    # m is calculated as result / 2 in the Java code context, but the final check is 2 * m == n.
    # If result = maxMatching(0, -1), then m = result / 2.
    # The check is 2 * (result / 2) == n, which simplifies to result == n.
    
    # Let's follow the Java calculation: int m = maxMatching(0, -1) / 2; out.println ( 2 * m == n ? "Second" : "First" ) ;
    # This means we check if maxMatching(0, -1) == n.
    
    if result == n:
        print("Second")
    else:
        print("First")

solve()