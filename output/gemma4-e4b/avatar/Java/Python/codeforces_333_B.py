import sys

def solve():
    # Read all input tokens
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    data_ptr = 0

    def get_next_int():
        nonlocal data_ptr
        if data_ptr < len(input_data):
            val = int(input_data[data_ptr])
            data_ptr += 1
            return val
        return None

    # Read N and M
    N = get_next_int()
    M = get_next_int()

    banned_rows = set()
    banned_cols = set()

    # Read M pairs (r, c)
    for _ in range(M):
        r = get_next_int()
        c = get_next_int()
        
        # Check bounds: 1 < r < N
        if r is not None and r > 1 and r < N:
            banned_rows.add(r)
        
        # Check bounds: 1 < c < N
        if c is not None and c > 1 and c < N:
            banned_cols.add(c)

    # Calculate initial answer
    answer = (N - 2) * 2
    answer -= len(banned_rows)
    answer -= len(banned_cols)

    # Handle odd N case
    if N % 2 != 0:
        # mid = (N + 1) / 2
        mid = (N + 1) // 2
        
        # If mid is not banned in both rows and columns
        if mid not in banned_rows and mid not in banned_cols:
            answer -= 1

    print(answer)

if __name__ == "__main__":
    solve()