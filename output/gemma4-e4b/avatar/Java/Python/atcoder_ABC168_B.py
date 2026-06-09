import sys

def solve():
    # Read all input from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first element is K, the second is S
    K = int(input_data[0])
    S = input_data[1]

    if len(S) <= K:
        print(S)
    else:
        print(S[:K] + "...")

if __name__ == "__main__":
    solve()