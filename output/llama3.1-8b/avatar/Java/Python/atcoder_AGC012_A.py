import sys
from typing import List

def main():
    n = int(input())
    array = list(map(int, input().split()))[:3*n]
    array.sort()
    head = len(array) - 2
    res = 0
    for i in range(n):
        res += array[head]
        head -= 2
    print(res)

if __name__ == "__main__":
    main()