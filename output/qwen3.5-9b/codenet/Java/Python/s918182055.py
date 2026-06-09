import sys
import heapq
from collections import defaultdict

def main():
    input_data = sys.stdin.read().split()
    iterator = iter(input_data)
    
    N = int(next(iterator))
    M = int(next(iterator))
    
    adj = defaultdict(list)
    
    for _ in range(N):
        a = int(next(iterator))
        b = int(next(iterator))
        adj[a].append(b)
    
    res = 0
    max_heap = []
    
    for i in range(1, M + 1):
        if i in adj:
            for b in adj[i]:
                heapq.heappush(max_heap, -b)
        if max_heap:
            res += -heapq.heappop(max_heap)
    
    print(res)

if __name__ == "__main__":
    main()