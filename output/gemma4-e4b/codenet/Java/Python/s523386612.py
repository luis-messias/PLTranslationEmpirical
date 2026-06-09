import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is t
    t = int(data[0])
    
    # Initialize count array of size t+1 (indices 0 to t)
    count = [0] * (t + 1)
    
    # The Java loop runs t-1 times, reading the next t-1 elements from the input stream.
    # These elements are stored in data[1] through data[t-1].
    
    # We iterate over the indices corresponding to the t-1 numbers to be counted.
    # The loop structure in Java (i=2 to t) dictates t-1 iterations.
    for i in range(t - 1):
        # data[1 + i] is the next value to read
        try:
            value = int(data[1 + i])
            # Assuming the input values are valid indices (0 to t)
            if 0 <= value <= t:
                count[value] += 1
        except IndexError:
            # Should not happen if input matches expected format
            break

    # Print the counts for indices 1 through t
    for i in range(1, t + 1):
        print(count[i])

solve()