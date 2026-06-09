import sys

def func(A):
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
        print(int(input()))
        sys.exit(0)
    a = []
    for _ in range(n):
        a.append(int(input()))
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