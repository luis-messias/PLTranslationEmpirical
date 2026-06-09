import sys
from typing import Set

def main():
    n = int(input().split()[0])
    k = int(input())
    arr = []
    set_ = set()

    for _ in range(n):
        arr.append(int(input().split()[0]))

    arr.sort()
    count = 0

    for i in range(n):
        if arr[i] % k != 0:
            count += 1
            set_.add(arr[i])
        elif (arr[i] // k) not in set_:
            count += 1
            set_.add(arr[i])

    print(count)

if __name__ == "__main__":
    main()
