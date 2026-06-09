import sys

def solve():
    # Read all input tokens
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # The first element is T, the number of test cases
    t = int(input_data[0])
    data_index = 1
    results = []

    for _ in range(t):
        # Read N, A, B for the current test case
        n = int(input_data[data_index])
        a = int(input_data[data_index+1])
        b = int(input_data[data_index+2])
        data_index += 3

        if n < a:
            results.append("No")
            continue

        if a == b:
            if n % a == 0:
                results.append("Yes")
            else:
                results.append("No")
            continue

        # Calculate x = b / (b - a)
        x = b // (b - a)

        # Case 1: N > x * a
        if n > x * a:
            results.append("Yes")
            continue

        # Binary search for 'ans' such that ans * a >= n
        low = 1
        high = x + 1
        ans = 1

        while low <= high:
            mid = (low + high) // 2
            if mid * a < n:
                low = mid + 1
            else:
                ans = mid
                high = mid - 1
        
        # Final check: if ( n > ( ans - 1 ) * b && n < ans * a )
        if n > (ans - 1) * b and n < ans * a:
            results.append("No")
        else:
            results.append("Yes")

    sys.stdout.write('\n'.join(results) + '\n')

solve()
