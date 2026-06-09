import sys

def solve():
    # Read all input tokens from stdin
    try:
        data = sys.stdin.read().split()
    except:
        return

    if not data:
        return

    if len(data) < 2:
        return

    try:
        # N is the first token, K is the second token
        n = int(data[0])
        k = int(data[1])
    except ValueError:
        return

    if len(data) < n + 2:
        # Not enough elements provided
        return

    # Read the array elements A (starting from index 2)
    a = []
    try:
        for i in range(n):
            a.append(int(data[2 + i]))
    except ValueError:
        return

    # Sort the array (equivalent to Arrays.parallelSort)
    a.sort()

    # Calculate the sum of the first K elements
    # We sum the first min(k, n) elements, but since we only read n elements, we sum the first k elements of a.
    ans = sum(a[:k])

    # Output the result
    print(ans)

if __name__ == "__main__":
    solve()