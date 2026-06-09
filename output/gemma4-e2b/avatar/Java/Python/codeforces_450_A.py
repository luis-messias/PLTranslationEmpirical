import sys
from collections import deque

def solve():
    # Read all input tokens
    try:
        data = sys.stdin.read().split()
    except:
        return

    if not data:
        return

    # n and m are the first two inputs
    if len(data) < 2:
        return
        
    n = int(data[0])
    m = int(data[1])
    
    # The remaining elements are the n numbers
    if len(data) < n + 2:
        return
        
    elements = [int(x) for x in data[2:n+2]]

    q1 = deque()
    q2 = deque()

    # Populate queues: q1 gets elements, q2 gets indices (1 to n)
    for i in range(1, n + 1):
        q1.append(elements[i - 1])
        q2.append(i)

    ans = 0

    # Process the queues
    while q1:
        current_val = q1[0]
        
        if current_val <= m:
            # If the current element is <= m, match it with the next available index
            x = q1.popleft()
            ans += q2.popleft()
        else:
            # If the current element is > m, transform it and swap with the next index
            x = q1.popleft()
            val = x - m
            q1.append(val)
            
            val2 = q2.popleft()
            q2.append(val2)

    print(ans)

solve()