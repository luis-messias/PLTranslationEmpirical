import sys

def solve():
    input_data = sys.stdin.read().split()
    N = int(input_data[0])
    max_val = min_val = int(input_data[1])
    for i in range(2, N + 1):
        val = int(input_data[i])
        max_val = max(max_val, val)
        min_val = min(min_val, val)
    print(max_val - min_val)

if __name__ == "__main__":
    solve()
