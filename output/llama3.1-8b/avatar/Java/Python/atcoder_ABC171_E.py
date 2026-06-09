import sys
from typing import List

def main():
    n = int(input())
    a = [int(x) for x in input().split()]
    r = 0
    for i in range(n):
        r ^= a[i]
    print(*[r ^ ai for ai in a])

if __name__ == "__main__":
    main()