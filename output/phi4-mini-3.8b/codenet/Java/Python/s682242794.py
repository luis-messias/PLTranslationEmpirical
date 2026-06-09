import sys

def solve():
    for i in range(7):
        high, low = map(int, input().split())
        print(high - low)

if __name__ == "__main__":
    solve()