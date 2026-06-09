import sys
from io import StringIO

class sc:
    def __init__(self):
        self.reader = sys.stdin.read().split()
        self.idx = 0
    
    def next(self):
        if self.idx >= len(self.reader):
            return None
        token = self.reader[self.idx]
        self.idx += 1
        return token
    
    def nextInt(self):
        return int(self.next())

def main():
    sc = sc()
    n = sc.nextInt()
    arr = [[sc.nextInt() for _ in range(3)] for _ in range(n)]
    
    dp = [[0] * 3 for _ in range(n)]
    dp[0][0] = arr[0][0]
    dp[0][1] = arr[0][1]
    dp[0][2] = arr[0][2]
    
    for i in range(1, n):
        for j in range(3):
            if j == 0:
                dp[i][j] = max(arr[i][0] + dp[i-1][1], arr[i][0] + dp[i-1][2])
            elif j == 1:
                dp[i][j] = max(arr[i][1] + dp[i-1][0], arr[i][1] + dp[i-1][2])
            elif j == 2:
                dp[i][j] = max(arr[i][2] + dp[i-1][1], arr[i][2] + dp[i-1][0])
    
    max_val = max(dp[n-1])
    print(max_val)

if __name__ == "__main__":
    main()
