import sys
from queue import PriorityQueue

def solve():
    N = int(input())
    arr = list(map(int, input().split()))
    q = PriorityQueue()
    for num in arr:
        q.put(num)
        if num <= q.queue[0]:
            N -= 1
    return N

print(solve())