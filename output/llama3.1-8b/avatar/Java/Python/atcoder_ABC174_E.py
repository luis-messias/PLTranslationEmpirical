import sys
input = sys.stdin.readline

class Solution:
    def solve(self):
        n, k = map(int, input().split())
        logsLength = list(map(int, input().split()))[:n]
        min_val = 1
        max_val = int(1e9) + 1000
        while min_val < max_val:
            mid = (min_val + max_val) // 2
            if self.nei(mid, logsLength, k):
                max_val = mid
            else:
                min_val = mid + 1
        print(min_val)

    def nei(self, mid, logsLength, k):
        for log in logsLength:
            k -= (log + mid - 1) // mid - 1
        return k >= 0

def main():
    n = int(input())
    k = int(input())
    logsLength = list(map(int, input().split()))[:n]
    solution = Solution()
    solution.solve()

if __name__ == "__main__":
    main()