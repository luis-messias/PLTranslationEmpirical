import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    data_ptr = 0

    # Read N, M, Q
    N = int(data[data_ptr])
    M = int(data[data_ptr + 1])
    Q = int(data[data_ptr + 2])
    data_ptr += 3

    # Initialize arrays A, B, C, D
    A = [0] * Q
    B = [0] * Q
    C = [0] * Q
    D = [0] * Q

    # Read constraints
    for i in range(Q):
        A[i] = int(data[data_ptr]) - 1
        B[i] = int(data[data_ptr + 1]) - 1
        C[i] = int(data[data_ptr + 2])
        D[i] = int(data[data_ptr + 3])
        data_ptr += 4

    # Global variable to store the maximum answer (equivalent to static long ans)
    # Initialize to a value smaller than any possible score (since D[i] >= 0, -1 is safe if scores are non-negative)
    max_ans = -float('inf')

    def dfs(current_list):
        nonlocal max_ans
        
        if len(current_list) == N:
            score = 0
            for i in range(Q):
                # Check the condition: list[B[i]] - list[A[i]] == C[i]
                # Note: list elements are 0-indexed, corresponding to values chosen from {1..M}
                if current_list[B[i]] - current_list[A[i]] == C[i]:
                    score += D[i]
