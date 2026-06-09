import sys

def solve():
    # Read all input tokens from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # N and M are the first two elements
    N = int(input_data[0])
    M = int(input_data[1])

    # Index counter for reading tokens
    idx = 2

    # Read matrix A (N rows, M columns)
    A = []
    for i in range(N):
        row = []
        for j in range(M):
            row.append(int(input_data[idx]))
            idx += 1
        A.append(row)

    # Read vector b (M elements)
    b = []
    for i in range(M):
        b.append(int(input_data[idx]))
        idx += 1

    # Calculate and print the dot product for each row
    results = []
    for i in range(N):
        c = 0
        for j in range(M):
            c += A[i][j] * b[j]
        results.append(c)

    # Print results, each on a new line
    sys.stdout.write('\n'.join(map(str, results)) + '\n')

solve()