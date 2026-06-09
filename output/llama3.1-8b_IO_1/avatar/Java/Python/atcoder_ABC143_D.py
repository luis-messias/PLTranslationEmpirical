import sys
from typing import List

def find(li: List[int], from_: int, target: int) -> int:
    low = from_
    upp = len(li) - 1
    mid = (upp - low + 1) // 2 if (upp - low + 1) % 2 == 0 else (low + upp) // 2
    while low <= upp:
        mid = (low + upp) // 2
        if li[mid] < target:
            low = mid + 1
        elif li[mid] > target:
            upp = mid - 1
        else:
            return mid - from_ + 1
    return 0

def main():
    N = int(input())
    L = []
    for _ in range(N):
        line = input()
        numbers = [int(x) for x in line.split()]
        L.extend(numbers)
    L.sort()
    count = 0
    for i in range(N):
        for j in range(i + 1, N):
            a = L[i]
            b = L[j]
            res = find(L, j + 1, a + b)
            count += res
    print(count)

if __name__ == "__main__":
    main()
