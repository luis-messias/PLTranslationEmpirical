import sys
from math import gcd

def main():
    x = int(input().split()[0])
    y = int(input().split()[0])
    a = int(input())
    b = int(input())

    j = 2
    c = max(x, y)
    ans = True

    if c > b:
        print(0)
        ans = False

    while c % min(x, y) != 0 and ans:
        if x > y:
            c = x * j
        else:
            c = y * j
        j += 1
        if c > b:
            print(0)
            ans = False
            break

    if ans:
        count = 0
        i = a
        while True:
            if i % c == 0:
                break
            i += 1
        if i != b + 1:
            g = gcd(x, y)
            print((b - i) // (c // g) + 1)
        else:
            print(0)

if __name__ == "__main__":
    main()
