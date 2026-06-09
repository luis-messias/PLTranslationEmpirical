import sys

# Set recursion limit higher for deep tree traversals
sys.setrecursionlimit(2000)

# Global graph structure (Adjacency List)
g = []

def maxMatching(v, p):
    """
    Calculates a value related to the maximum matching size in the subtree rooted at v.
    This function translates the specific recursive logic provided in the Java source.
    """
    global g
    a = 0  # Accumulates sum of (r / 2)
    o = 0  # Accumulates sum of (r % 2)
    
    for w in g[v]:
        if w == p:
            continue
        
        r = maxMatching(w, v