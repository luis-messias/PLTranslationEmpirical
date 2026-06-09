import sys

def main():
    n, k = map(int, sys.stdin.readline().split())
    a = list(map(int, sys.stdin.read().split()))
    
    l = 0
    c = 1
    for i in range(n):
        if a[i] == l:
            c += 1
        else:
            c = 1
        l = a[i]
    
    if c + k > n:
        print(n - c)
    else:
        print(-1)

if __name__ == "__main__":
    main()
