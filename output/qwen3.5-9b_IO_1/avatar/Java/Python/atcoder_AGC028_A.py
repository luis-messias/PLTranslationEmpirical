import sys
from math import gcd

def main():
    line1 = sys.stdin.readline().split()
    n = int(line1[0])
    m = int(line1[1])
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
