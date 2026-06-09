import sys

# Set recursion limit higher for deep tree traversals
# The original Java code implies a tree structure, so increasing the limit is necessary.
sys.setrecursionlimit(3000)

# Global graph structure (Adjacency List)
g = []

def maxMatching(v, p):
    """
    Calculates a value related to the maximum matching size in the subtree rooted at v,
    following the specific recursive logic from the Java source.
    """
    global g
    a = 0  # Accumulates sum of (r // 2)
    o = 0  # Accumulates sum of (r % 2)
    
    for w in g[v]:
        if w == p:
            continue
        
        # Corrected recursive call: must close parenthesis
        r = maxMatching(w, v)
        
        # Java integer division r / 2 translates to Python integer division r // 2
        a += r // 2
        o += r % 2
        
    # Math.min(1, o)
    return 2 * a + min(1, o) + 1

def solve():
    global g
    
    # Read all input data
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # N is the first element
    n = int(input_data[0])
    
    # Initialize graph structure
    g = [[] for _ in range(n)]
    
    # Input data starts from index 1. Edges are pairs (a, b).
    data_index = 1
    for _ in range(n - 1):
        # Read a and b (1-based)
        a = int(input_data[data_index]) - 1
        b = int(input_data[data_index + 1]) - 1
        data_index += 2
        
        # Build adjacency list
        g[a].append(b)
        g[b].append(a)

    # Calculate maxMatching(0, -1)
    # The result is divided by 2 to get m.
    result = maxMatching(0, -1)
    m = result // 2
    
    # Determine the output string
    if 2 * m == n:
        print("Second")
    else:
        print("First")

if __name__ == "__main__":
    solve()
