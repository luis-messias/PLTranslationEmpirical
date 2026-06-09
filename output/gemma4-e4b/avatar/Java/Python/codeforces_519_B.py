import sys

def solve():
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    data_iter = iter(input_data)

    try:
        n = int(next(data_iter))
    except StopIteration:
        return

    # Calculate A (N elements)
    a = 0
    for _ in range(n):
        try:
            a += int(next(data_iter))
        except StopIteration:
            break

    # Calculate B (N-1 elements)
    b = 0
    for _ in range(n - 1):
        try:
            b += int(next(data_iter))
        except StopIteration:
            break

    # Calculate C (N-2 elements)
    c = 0
    for _ in range(n - 2):
        try:
            c += int(next(data_iter))
        except StopIteration:
            break

    x = a - b
    y = b - c
    
    print(x)
    print(y)

solve()