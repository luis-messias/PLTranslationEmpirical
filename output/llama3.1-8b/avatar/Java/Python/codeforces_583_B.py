import sys

def main():
    n = int(input())
    a = []
    b = [0] * n
    q = 0
    s = 0
    for i in range(n):
        a.append(int(input()))
    
    tem = 1
    while q != n:
        s += 1
        if tem == 1:
            for i in range(n):
                if a[i] <= q and b[i] == 0:
                    b[i] = 1
                    q += 1
            tem = 0
        else:
            for i in range(n-1, -1, -1):
                if a[i] <= q and b[i] == 0:
                    b[i] = 1
                    q += 1
            tem = 1
    
    print(s)

if __name__ == "__main__":
    main()