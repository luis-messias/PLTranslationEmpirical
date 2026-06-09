import sys

def fun(arr, q, n):
    low, high = 0, n-1
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == q:
            return mid
        elif arr[mid] > q:
            res = mid
            high = md - 1
        else:
            low = md + 1
    return res

def main():
    n = int(input())
    arr = [0]*n
    for i in range(n):
        x = list(map(int, input().split()))
        if i == 0:
            arr[i] = x[0]
        else:
            arr[i] = x[0] + arr[i-1]
    m = int(input())
    q = []
    for _ in range(m):
        q.append(int(input()))
    for k in range(m):
        print(fun(arr, q[k], n) + 1)

if __name__ == "__main__":
    main()
