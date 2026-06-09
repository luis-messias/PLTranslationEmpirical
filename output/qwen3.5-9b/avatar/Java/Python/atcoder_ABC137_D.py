import heapq
import sys

class Job:
    def __init__(self, a, b):
        self.a = a
        self.b = b
    
    def __lt__(self, other):
        if self.a == other.a:
            return self.b < other.b
        return self.a < other.a

def main():
    input = sys.stdin.readline
    
    line = input().split()
    N = int(line[0])
    M = int(line[1])
    
    job_queue = []
    for _ in range(N):
        line = input().split()
        a = int(line[0])
        b = int(line[1])
        job_queue.append((a, b))
    
    # Sort by a, then b (min heap)
    job_queue.sort()
    
    # Max heap for b values (using negative)
    jobQ = []
    
    cnt = 0
    for i in range(1, M + 1):
        # Move available jobs to jobQ
        while job_queue and job_queue[0][0] <= i:
            a, b = heapq.heappop(job_queue)
            heapq.heappush(jobQ, -b)
        
        if jobQ:
            cnt += -heapq.heappop(jobQ)
    
    print(cnt)

if __name__ == "__main__":
    main()