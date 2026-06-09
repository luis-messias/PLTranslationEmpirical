import sys

# Read all input tokens
data = sys.stdin.read().split()

if len(data) >= 6:
    # The first 5 elements are the array elements
    numlist = [int(x) for x in data[:5]]
    # The 6th element is k
    k = int(data[5])

    if (numlist[4] - numlist[0]) > k:
        print(":(")
    else:
        print("Yay!")