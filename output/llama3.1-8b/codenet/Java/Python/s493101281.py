import sys
from typing import List, Tuple

MOD = 1000000007

def main():
    n = int(input())
    l = sorted([int(x) for x in input().split()])

    print(l[n//2] - l[(n-1)//2])

if __name__ == "__main__":
    main()