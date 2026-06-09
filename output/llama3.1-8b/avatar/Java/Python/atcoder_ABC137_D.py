import heapq
class Job:
    def __init__(self, a, b):
        self.a = a
        self.b = b

    def __lt__(self, otherJob):
        if self.a == otherJob.a:
            return self.b < otherJob.b
        else:
            return self.a < otherJob.a

def main():
    N, M = map(int, input().split())
    q = []
    for _ in range(N):
        a, b = map(int, input().split())
        heapq.heappush(q, (a, b))
    
    jobQ = []
    cnt = 0
    for i in range(1, M+1):
        while q and q[0][0] <= i:
            _, b = heapq.heappop(q)
            heapq.heappush(jobQ, -b)
        
        if jobQ:
            cnt += -heapq.heappop(jobQ)

    print(cnt)

if __name__ == "__main__":
    main()