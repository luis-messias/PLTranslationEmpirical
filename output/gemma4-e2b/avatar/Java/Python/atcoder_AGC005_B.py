import sys
from collections import deque

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # Input parsing
    N = int(data[0])
    A = [int(x) for x in data[1:N+1]]

    # Initialize results arrays
    leftl = [0] * N
    rightl = [0] * N
    
    # --- Calculate rightl (Forward pass) ---
    que = deque()
    index = 0
    
    # Phase 1: Process elements from left to right
    while index < N:
        # Pop elements from the stack whose values are greater than A[index]
        while que and A[que[-1]] > A[index]:
            ind = que.pop()
            # rightl[ind] stores the count of elements between ind and index
            rightl[ind] = index - ind - 1
        
        que.append(index)
        index += 1
    
    # Phase 2: Process remaining elements in the stack
    while que:
        ind = que.pop()
        # If an element remains in the stack, it means there is no smaller element to its right.
        # The right boundary is N.
        rightl[ind] = N - ind - 1

    # --- Calculate leftl (Backward pass) ---
    que = deque()
    index = N - 1
    
    # Phase 1: Process elements from right to left
    while index >= 0:
        # Pop elements from the stack whose values are greater than A[index]
        while que and A[que[-1]] > A[index]:
            ind = que.pop()
            # leftl[ind] stores the count of elements between index and ind
            leftl[ind] = ind - index - 1
        
        que.append(index)
        index -= 1

    # Phase 2: Process remaining elements in the stack
    while que:
        ind = que.pop()
        # If