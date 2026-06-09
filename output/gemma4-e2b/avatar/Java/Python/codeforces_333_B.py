import sys

def solve():
    # Read all input tokens
    try:
        data = sys.stdin.read().split()
    except:
        return

    if not data:
        return

    data_iter = iter(data)

    def next_int():
        try:
            return int(next(data_iter))
        except StopIteration:
            # Should not happen if input is well-formed based on M
            raise EOFError("Unexpected end of input")

    try:
        N = next_int()
        M = next_int()
    except StopIteration:
        return

    banned_rows = set()
    banned_cols = set()

    for _ in range(M):
        try:
            R = next_int()
            C = next_int()
        except StopIteration:
            # Ran out of R/C pairs prematurely
            break
        
        # Check row constraints: 1 < r < n
        if 1 < R < N:
            banned_rows.add(R)
        
        # Check column constraints: 1 < c < n
        if 1 < C < N:
            banned_cols.add(C)

    # Calculate initial answer
    answer = (N - 2) * 2
    answer -= len(banned_rows)
    answer -= len(banned_cols)

    # Middle element check
    if N % 2 != 0:
        mid = (N + 1) // 2
        
        if mid not in banned_rows and mid not in banned_cols:
            answer -= 1

    print(answer)

solve()