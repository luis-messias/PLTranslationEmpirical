import sys
from collections import deque

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # n is the first element, b is the second
    n = int(data[0])
    b = int(data[1])
    
    # The remaining data are pairs (t, d)
    input_index = 2
    
    ans = [0] * n
    q = deque()

    for i in range(n):
        t = int(data[input_index])
        d = int(data[input_index + 1])
        input_index += 2

        # While q is not empty and q[0] <= t
        while q and q[0] <= t:
            q.popleft()

        if len(q) <= b:
            # Calculate ans[i]
            if not q:
                # q is empty, use t
                result = t
            else:
                # Use q.getLast() (which is q[-1] in Python deque)
                result = q[-1]
            
            ans[i] = result + d
            
            # Add ans[i] to q
            q.append(ans[i])
        else:
            ans[i] = -1

    # Print the results separated by spaces
    print(*(ans))

solve()