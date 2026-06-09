import sys

def main():
    input = sys.stdin.read
    data = list(map(int, input().split()))
    
    n = len(data)
    arr = [0] * (n + 1)

    for i in range(n):
        arr[i+1] = data[i]

    dp1 = [0] * (n + 2)
    dp2 = [0] * (n + 2)

    cost1, current1 = 0, 0
    cost2, current2 = 0, 0

    for i in range(n):
        if arr[i+1] != current1:
            cost1 += abs(arr[i+1] - current1)
            dp1[i + 1] = cost1
            current1 = arr[i+1]

    j = n-1
    while j >= 0 and (arr[j+1] == current2 or i < len(dp1) - 1):
        if arr[j+1] != current2:
            cost2 += abs(arr[j+1] - current2)
            dp2[i + 1] = cost2
            current2 = arr[j+1]
        j -= 1

    for i in range(n-1, n+1):
        if i == 0 and len(dp1) > 1:
            print(f"{dp2[1]} {abs(arr[1])}")
        elif i >= len(dp1)-1 or (i < len(dp1)):
            print(f"{dp1[i - 1] + abs(arr[i-1]) if i != n else dp2[i+1] + abs(arr[i])}")

if __name__ == "__main__":
    main()