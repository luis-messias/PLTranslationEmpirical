import sys
from typing import List

def main():
    n = int(input())
    arr: List[int] = []
    for i in range(n):
        x = input().split()
        if x[0] == '1':
            arr.append(i)
    if not arr:
        print(0)
    else:
        result = 1
        for i in range(1, len(arr)):
            result *= arr[i] - arr[i-1]
        print(result)

if __name__ == "__main__":
    main()
