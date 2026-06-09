import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    # The input consists of 7 pairs of (high, low), meaning 14 numbers total.
    # We iterate 7 times, reading two numbers in each iteration.
    for i in range(7):
        # data[2*i] is high, data[2*i + 1] is low
        if 2 * i + 1 < len(data):
            high = int(data[2*i])
            low = int(data[2*i + 1])
            sa = high - low
            print(sa)

if __name__ == "__main__":
    solve()