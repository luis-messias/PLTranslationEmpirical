import sys

def solve():
    # Read all input tokens from stdin
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # The first element is N
    try:
        n = int(input_data[0])
    except ValueError:
        # Handle case where N might not be readable
        return

    # The remaining elements are the indices
    indices = [int(x) for x in input_data[1:]]

    # Array to store counts (size 1001 for indices 0 to 1000)
    # Initialize with zeros
    array = [0] * 1001

    # Count frequencies
    for index in indices:
        if 0 <= index < 1001:
            array[index] += 1

    # Find countMax (maximum frequency for indices 1 to 1000)
    count_max = -1
    # Iterate from index 1 up to 1000 (inclusive)
    for i in range(1, 1001):
        if count_max < array[i]:
            count_max = array[i]

    # Determine the result based on N's parity
    if n % 2 == 0:
        # N is even
        threshold = n // 2
        if count_max <= threshold:
            print("YES")
        else:
            print("NO")
    else:
        # N is odd
        # n / 2 + 1 is equivalent to (n + 1) // 2 using integer division
        threshold = n // 2 + 1
        if count_max <= threshold:
            print("YES")
        else:
            print("NO")

if __name__ == "__main__":
    solve()