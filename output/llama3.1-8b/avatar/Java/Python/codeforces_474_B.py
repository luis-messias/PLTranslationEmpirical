import sys

def fun(arr, q, n):
    low, high = 0, n-1
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == q:
            return mid
        elif arr[mid] > q:
            res = mid
            high = mid - 1
        else:
            low = mid + 1
    return res

def main():
    n = int(input())
    arr = [0]*n
    arr[0] = int(input())
    for i in range(1, n):
        x = int(input())
        arr[i] = x + arr[i-1]
    m = int(input())
    q = []
    for _ in range(m):
        q.append(int(input()))
    for k in range(m):
        print(fun(arr, q[k], n) + 1)

if __name__ == "__main__":
    main()