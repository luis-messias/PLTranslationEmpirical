import sys
import heapq

def solve():
    # Read all input lines
    data = sys.stdin.read().split()
    if not data:
        return

    # N and M are the first two integers
    N = int(data[0])
    M = int(data[1])
    
    # The remaining data are the job pairs (a, b)
    job_data = data[2:]
    
    # q will store jobs, prioritized by a ascending, b descending.
    # We use a min-heap. To achieve b descending for ties in a, we store (-b).
    q = []
    for i in range(N):
        a = int(job_data[2 * i])
        b = int(job_data[2 * i + 1])
        # Store (a, -b) for min-heap behavior matching Java's compareTo
        heapq.heappush(q, (a, -b))

    # jobQ will store the 'b' values that qualify, acting as a max-heap.
    # Since we want to extract the largest 'b' values, we use a min-heap of negative values.
    jobQ = []
    
    # Process jobs
    for i in range(1, M + 1):
        # Move jobs from q to jobQ if job.a <= i
        while q:
            a, neg_b = heapq.heappop(q)
            b = -neg_b
            
            if a <= i:
                # Add b to jobQ (as -b to simulate max-heap)
                heapq.heappush(jobQ, -b)
            else:
                # Since q is sorted by a ascending, if the current job doesn't qualify, 
                # no subsequent jobs will qualify either (if we assume the input order 
                # doesn't matter for the processing order, which is true for a standard PQ).
                # However, the Java code breaks immediately, implying we stop checking q 
                # once the condition fails for the current peeked job.
                # Since q is a min-heap on 'a', if the smallest 'a' job doesn't qualify, 
                # we break.
                break
        
        # After processing all jobs that qualify for the current i, 
        #