import sys

def solve():
    N = input()
    max, min = map(int, (input() for _ in range(N))
    for i in range(1, N):
        in_ = int(input())
        if in_ > 0:
            max = max(in_, max)
            if in_ < 0 and -in_ not in [max]:
                min = min(-in_, min) or (min := abs(min))
    print(max - min)

if __name__ == "__main__":
    solve()