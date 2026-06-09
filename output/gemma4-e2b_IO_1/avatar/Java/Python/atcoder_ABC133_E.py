import sys

# Increase recursion limit for deep recursive calls
sys.setrecursionlimit(2000)

class Node:
    def __init__(self, i):
        self.index = i
        self.children = []
        self.parent = -1
        self.pattern = 0

    def set_parent(self, K, parent, use, nodes):
        # This method calculates the pattern and recursively calls itself
        self.pattern = K - use
        self.parent = parent
        
        # Determine the count based on parent existence
        count = 1
        if parent != -1:
            count += 1
        
        # Iterate over neighbors (children in this context)
        for n in self.children:
            if n == self.parent:
                continue
            
            # Recursive call: passing K, current node's index (as 'use'), calculated count, and the nodes array
            nodes[n].set_parent(K, self.index, count, nodes)
            
            # Increment count for the next sibling/child
            count += 1

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    if not data:
        return

    # Input parsing based on Java structure: N, K, followed by 2*(N-1) edge endpoints
    if len(data) < 2
