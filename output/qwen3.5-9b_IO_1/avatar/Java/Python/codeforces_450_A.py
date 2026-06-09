import sys
from collections import deque

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    m = int(input_data[1])
    
    q1 = deque()
    q2 = deque()
    
    for i in range(1, n + 1):
        q1.append(int(input_data[2 + i - 1]))
        q2.append(i)
    
    ans = 0
    while q1:
        if q1[0] <= m:
            q1.popleft()
            ans = q2.popleft()
        else:
            x = q1.popleft()
            val = x - m
            q1.append(val)
            val2 = q2.popleft()
            q2.append(val2)
    
    print(ans)

if __name__ == "__main__":
    main()
