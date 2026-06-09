import sys
from queue import PriorityQueue

def solve():
    N = int(input())
    arr = list(map(int, input().split()))
    q = PriorityQueue()
    sum = 0
    for num in arr:
        q.put(num)
        if num <= q.queue[0]:
            sum += 1
    return sum

print(solve())
