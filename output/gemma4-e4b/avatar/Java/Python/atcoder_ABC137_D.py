import heapq
import sys

def solve():
    # Read all input lines
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # N and M are the first two elements
    N = int(input_data[0])
    M = int(input_data[1])

    # Jobs data starts from index 2
    jobs_data = []
    for i in range(N):
        a = int(input_data[2 + i * 2])
        b = int(input_data[3 + i * 2])
        jobs_data.append((a, b))

    # q: Priority Queue for all jobs.
    # We need sorting by (a asc, b desc).
    # In a min-heap, we store (a, -b) to achieve this.
    q = []
    for a, b in jobs_data:
        heapq.heappush(q, (a, -b))

    # jobQ: Priority Queue for available job values (b).
    # We need a Max Heap on b. We store -b in the min-heap.
    jobQ = []
    
    cnt = 0

    # Iterate through time steps i = 1 to M
    for i in range(1, M + 1):
        # 1. Load available jobs into jobQ
        while q and q[0][0] <= i:
            # Pop (a, -b)
            _, neg_b = heapq.heappop(q)
            b = -neg_b
            
            # Push -b onto jobQ (Max Heap on b)
            heapq.heappush(jobQ, -b)

        # 2. Process the best available job
        if jobQ:
            # The best job is the one with the largest b (smallest -b)
            neg_b_processed = heapq.heappop(jobQ)
            b_processed = -neg_b_processed
            cnt += b_processed

    print(cnt)

if __name__ == "__main__":
    solve()