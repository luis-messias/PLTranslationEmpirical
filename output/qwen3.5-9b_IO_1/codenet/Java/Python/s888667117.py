import sys

def main():
    Si = sys.stdin.read().strip()
    S = list(Si[::-1])
    
    dp = [0] * 13
    dp[0] = 1
    
    d = 1
    for i, c in enumerate(S):
        nd = [0] * 13
        
        if c.isdigit():
            x = (int(c) * d) % 13
            for j in range(13):
                nd[(j + x) % 13] = dp[j]
        else:
            for xi in range(10):
                x = (xi * d) % 13
                for j in range(13):
                    ni = (j + x) % 13
                    nd[ni] = (nd[ni] + dp[j]) % 1000000007
        
        dp = nd
        d = (d * 10) % 13
    
    print(dp[5])

if __name__ == "__main__":
    main()
