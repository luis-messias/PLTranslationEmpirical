import sys

def func(a):
    a = [x for x in a if x != 0]
    if not a:
        return a
    min_val = a[0]
    for i in range(len(a)):
        if a[i] == 0:
            continue
        if min_val != 0:
            a[i] = a[i] % min_val
            if a[i] == 1:
                print(1)
                sys.exit(0)
        else:
            min_val = a[i]
    a.sort()
    return a

def main():
    n = int(input())
    if n == 1:
        print(int(input()))
        return
    
    a = list(map(int, input().split()))
    
    a.sort()
    if a[-1] == 0:
        print(0)
        return
    
    ans = 0
    while True:
        if len(a) == 1:
            ans = a[0]
            break
        a = func(a)
    
    print(ans)

if __name__ == "__main__":
    main()
