import sys

MOD = 1000000007
TOKENS = ["A", "C", "G", "T"]

memo = {}

def isOK(last4):
    if "AGC" in last4:
        return False
    for i in range(3):
        vals = list(last4)
        vals[i] = last4[i+1]
        vals[i+1] = last4[i]
        s = "".join(vals)
        if "AGC" in s:
            return False
    return True

def dfs(current, last3):
    key = (current, last3)
    if key in memo:
        return memo[key]
    
    if current == N:
        return 1
    
    result = 0
    for c in TOKENS:
        if isOK(last3 + c):
            result = (result + dfs(current + 1, last3[1:] + c)) % MOD
    
    memo[key] = result
    return result

def main():
    global N
    N = int(input())
    print(dfs(0, "TTT"))

if __name__ == "__main__":
    main()
