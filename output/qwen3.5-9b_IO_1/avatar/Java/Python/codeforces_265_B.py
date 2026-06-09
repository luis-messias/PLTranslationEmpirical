import sys

input_data = sys.stdin.read().split()
n = int(input_data[0])
arr = list(map(int, input_data[1:n+1]))
ans = arr[0] + 1
for i in range(1, n):
    ans += abs(arr[i] - arr[i - 1]) + 2
print(ans)
