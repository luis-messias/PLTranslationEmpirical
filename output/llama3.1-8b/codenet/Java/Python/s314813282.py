import sys

def main():
    m = int(input())
    n = int(input())
    x = int(input())
    y = int(input())
    a = [int(input()) for _ in range(m)]
    b = [int(input()) for _ in range(n)]
    x_max = max_int(x, a)
    y_min = min_int(y, b)
    check_war(x_max, y_min)

def max_int(x, a):
    bignum = x
    for num in a:
        bignum = max(bignum, num)
    return bignum

def min_int(y, b):
    smallnum = y
    for num in b:
        smallnum = min(smallnum, num)
    return smallnum

def check_war(a, b):
    if a >= b:
        print("War")
    else:
        print("No War")

if __name__ == "__main__":
    main()