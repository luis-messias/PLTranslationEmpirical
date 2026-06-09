import sys
from collections import deque

def solve():
    # Read all input data from standard input
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element, M is the second
    N = int(data[0])
    M = int(data[1])

    # q1 gets the next N elements (the values)
    q1 = deque(map(int, data[2:2 + N]))

    # q2 gets indices 1 to N
    q2 = deque(range(1, N + 1))

    ans = 0

    while q1:
        # Peek operation: q1[0]
        
        if q1[0] <= M:
            # Process the element
            q1.popleft()
            ans = q2.popleft()
        else:
            # Process the element (x > M)
            x = q1.popleft()
            val = x - M
            
            # Enqueue the new value
            q1.append(val)
            
            # Handle the corresponding index
            val2 = q2.popleft()
            q2.append(val2)

    print(ans)

if __name__ == "__main__":
    solve()