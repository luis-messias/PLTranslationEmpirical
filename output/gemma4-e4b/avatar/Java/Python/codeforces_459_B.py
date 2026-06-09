import sys

def solve():
    # Read all input tokens from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first element is N
    try:
        N = int(input_data[0])
    except IndexError:
        return

    # The remaining N elements form the array A
    if len(input_data) < N + 1:
        # Handle case where input might be incomplete
        return
        
    A = [int(x) for x in input_data[1:N+1]]

    if N == 0:
        # Edge case: empty array
        print("0 0")
        return

    # Sort the array
    A.sort()

    # Determine min and max
    min_val = A[0]
    max_val = A[N - 1]

    # Count occurrences
    mins = A.count(min_val)
    maxs = A.count(max_val)

    if min_val == max_val:
        # Case 1: All elements are the same
        # The number of pairs is n * (n - 1) / 2
        pairs = mins * (mins - 1) // 2
        print(f"{max_val - min_val} {pairs}")
    else:
        # Case 2: min != max
        # The number of pairs is mins * maxs
        pairs = mins * maxs
        print(f"{max_val - min_val} {pairs}")

if __name__ == "__main__":
    solve()