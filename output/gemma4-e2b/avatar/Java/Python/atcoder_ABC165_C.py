import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # Initialize pointers for reading data
    data_ptr = 0

    # Read N, M, Q
    N = int(data[data_ptr])
    M = int(data[data_ptr + 1])
    Q = int(data[data_ptr + 2])
    data_ptr += 3

    # Initialize arrays a, b, c, d
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
    max_ans = -100L

    def dfs(current_list):
        nonlocal max_ans
        
        if len(current_list) == N:
            score = 0L
            for i in range(Q):
                # Check the condition: list[B[i]] - list[A[i]] == C[i]
                if current_list[B[i]] - current_list[A[i]] == C[i]:
                    score += D[i]
            
            if score > max_ans:
                max_ans = score
            return

        # Recursive step: Try adding numbers from 1 to M
        
        # Determine the starting number for iteration
        if not current_list:
            start_num = 1
        else:
            # Java logic: starts from the last added element + 1
            start_num = current_list[-1] + 1
        
        for num in range(start_num, M + 1):
            # Add num to the list
            current_list.append(num)
            
            # Recurse
            dfs(current_list)
            
            # Backtrack: Remove num
            current_list.pop()

    # Start the search
    dfs([])

    print(max_ans)

solve()