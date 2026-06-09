import sys

def main():
    m, n = map(int, input().split())
    x = int(input())
    y = int(input())

    a = list(map(int, input().split()))
    
    b = list(map(int, input().split()))

    max_x = MaxInt(x, a)
    min_y = MinInt(y, b)

    CheckWar(max_x, min_y)


def MaxInt(x, arr):
    return max(x, *arr)


def MinInt(y, arr):
    return min(y, *arr)


def CheckWar(a, b):
    if a >= b:
        print("War")
    else:
        print("No War")


if __name__ == "__main__":
    main()