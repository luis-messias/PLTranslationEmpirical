import math
import sys

def modPow(b, e, mod):
    return pow(b, e, mod)

def modInv(x, mod):
    return modPow(x, mod - 2, mod)

def modDiv(a, b, mod):
    return (a % mod) * modInv(b, mod) % mod

def main():
    input = sys.stdin.read
    data = input().split()
    
    N = int(data[0])
    A = [int(data[i+1]) for i in range(N)]
    
    lcm = 1
    for ai in A:
        lcm = lcm * ai // math.gcd(lcm, ai)
    
    mod = 1000000007
    modLcm = lcm % mod
    
    ans = 0
    for ai in A:
        ans = (ans + modDiv(modLcm, ai, mod)) % mod
    
    print(ans)

if __name__ == "__main__":
    main()