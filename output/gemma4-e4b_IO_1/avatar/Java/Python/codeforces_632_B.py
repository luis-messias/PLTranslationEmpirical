import sys

def solve():
    # Read all input tokens from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # N is the first element
    N = int(input_data[0])
    
    # A are the next N elements
    A = [int(x) for x in input_data[1:N+1]]
    
    # S is the last element
    S = input_data[N+1]

    # 1. Calculate initial sum (sum of A[i] where S[i] == 'B')
    sum_b = 0
    for i in range(len(S)):
        if S[i] == 'B':
            sum_b += A[i]
    
    ans = sum_b
    
    # 2. Forward pass (Prefix sum calculation)
    sum1 = sum_b
    for i in range(len(S)):
        if S[i] == 'A':
            sum1 += A[i]
        else:
            sum1 -= A[i]
        ans = max(ans, sum1)
        
    # 3. Backward pass (Suffix sum calculation)
    sum1 = sum_b
