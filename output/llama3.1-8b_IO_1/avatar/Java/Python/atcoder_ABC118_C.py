import sys
from typing import List

def func(A: List[int]) -> List[int]:
    a = A[:]
    min_val = 0
    for i in range(len(a)):
        if a[i] == 0:
            del a[i]
            i -= 1
        else:
            if min_val != 0:
                a[i] %= min_val
                if a[i] == 1:
                    print(1)
                    sys.exit(0)
            else:
                min_val = a[i]
    return sorted(a)

def main():
    n = int(input())
    if n == 1:
        ans = int(input())
        print(ans)
        sys.exit(0)
    a = []
    for _ in range(n):
        line = input().split()
        try:
            a.append(int(line[0]))
        except ValueError:
            print("Invalid input. Please enter an integer.")
            sys.exit(1)
    a.sort()
    if a[-1] == 0:
        print(0)
        sys.exit(0)
    ans = 0
    while True:
        if len(a) == 1:
            ans = a[0]
            break
        a = func(a)
    print(ans)

if __name__ == "__main__":
    main()
