n = int(input())
nums = list(map(int, input().split()))
arr = [i for i, x in enumerate(nums) if x == 1]
if not arr:
    print(0)
else:
    result = 1
    for i in range(1, len(arr)):
        result *= (arr[i] - arr[i-1])
    print(result)
