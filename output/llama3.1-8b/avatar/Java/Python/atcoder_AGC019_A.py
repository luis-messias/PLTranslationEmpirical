import sys
from typing import List

def main():
    Q = int(input())
    H = int(input())
    S = int(input())
    D = int(input())
    N = int(input())

    onePrice = min(min(Q * 4, H * 2), S)
    if onePrice <= D / 2:
        print(N * onePrice)
    else:
        print((N // 2) * D + (N % 2) * onePrice)

if __name__ == "__main__":
    main()