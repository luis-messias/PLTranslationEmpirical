import sys

def solve():
    # Read the single integer N from standard input
    try:
        # Read all input and strip whitespace, then convert to int
        input_data = sys.stdin.read().strip()
        if not input_data:
            return
        n = int(input_data)
    except Exception:
        return

    if n < 0:
        # Handle negative input if necessary, though the logic assumes n >= 0
        return

    # Initialize the list/array of size n + 1
    ryuka = [0] * (n + 1)

    # Base cases
    if n >= 0:
        ryuka[0] = 2
    if n >= 1:
        ryuka[1] = 1

    # Calculate the sequence using dynamic programming
    for i in range(2, n + 1):
        ryuka[i] = ryuka[i - 1] + ryuka[i - 2]

    # Print the result
    print(ryuka[n])

solve()