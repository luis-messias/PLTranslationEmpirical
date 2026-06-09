import sys

def solve():
    # Read all input tokens from standard input
    data = sys.stdin.read().split()

    if len(data) < 6:
        # Handle case where not enough input is provided
        return

    # The first 5 elements are the numbers in numlist
    numlist = [int(data[i]) for i in range(5)]
    
    # The 6th element is k
    k = int(data[5])

    # Check the condition: numlist[4] - numlist[0] > k
    if (numlist[4] - numlist[0]) > k:
        print(":(")
    else:
        print("Yay!")

if __name__ == "__main__":
    solve()