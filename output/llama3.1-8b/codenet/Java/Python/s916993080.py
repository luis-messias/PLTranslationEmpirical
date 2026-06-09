import sys

class InputReader:
    def __init__(self):
        self.reader = sys.stdin

    def next(self):
        return self.reader.readline().strip()

    def next_int(self):
        return int(self.next())

    def next_long(self):
        return int(self.next())

    def next_double(self):
        return float(self.next())

def main():
    reader = InputReader()
    n = reader.next_int()
    arr = [[0 for _ in range(3)] for _ in range(n)]
    for i in range(n):
        for j in range(3):
            arr[i][j] = reader.next_int()

    dp = [[0 for _ in range(3)] for _ in range(n)]
    dp[0][0] = arr[0][0]
    dp[0][1] = arr[0][1]
    dp[0][2] = arr[0][2]

    for i in range(1, n):
        for j in range(3):
            if j == 0:
                dp[i][j] = max(arr[i][0] + dp[i-1][1], arr[i][0] + dp[i-1][2])
            elif j == 1:
                dp[i][j] = max(arr[i][1] + dp[i-1][0], arr[i][1] + dp[i-1][2])
            else:
                dp[i][j] = max(arr[i][2] + dp[i-1][1], arr[i][2] + dp[i-1][0])

    max_val = -1
    for i in range(3):
        if dp[n-1][i] > max_val:
            max_val = dp[n-1][i]

    print(max_val)

if __name__ == "__main__":
    main()