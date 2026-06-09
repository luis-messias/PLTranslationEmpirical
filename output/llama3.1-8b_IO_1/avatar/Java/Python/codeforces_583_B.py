import sys
from typing import List

def main():
    n = int(input())
    a = list(map(int, input().split()))
    b = [0] * n
    q = 0
    s = -1
    tem = 1
    
    for i in range(n):
        if b[i] == 0:
            b[i] = 1
            q += 1
    
    while q != n:
        s += 1
        if tem == 1:
            for i in range(n-2, -1, -1):
                if a[i] <= q and b[i] == 0:
                    b[i] = 1
                    q += 1
            tem = 0
        else:
            for i in range(1, n):
                if a[i] <= q and b[i] == 0:
                    b[i] = 1
                    q += 1
            tem = 1
    
    print(s)

if __name__ == "__main__":
    main()
