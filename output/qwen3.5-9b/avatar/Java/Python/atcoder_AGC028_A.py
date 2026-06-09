import sys
from math import gcd

def main():
    n = int(sys.stdin.readline())
    m = int(sys.stdin.readline())
    g = gcd(n, m)
    s = sys.stdin.readline().strip()
    t = sys.stdin.readline().strip()
    
    lcm = n * m // g
    
    for k in range(g):
        if s[k * n // g] != t[k * m // g]:
            print(-1)
            return
    
    print(lcm)

if __name__ == "__main__":
    main()