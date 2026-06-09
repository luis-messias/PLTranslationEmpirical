import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    a = [int(x) for x in input_data[1:n+1]]
    
    cost1 = 0
    cost2 = 0
    current1 = 0
    current2 = 0
    dp1 = [0] * n
    dp2 = [0] * n
    
    for i in range(n):
        j = n - 1 - i
        cost1 += abs(a[i] - current1)
        current1 = a[i]
        dp1[i] = cost1
        cost2 += abs(a[j] - current2)
        current2 = a[j]
        dp2[j] = cost2
    
    for i in range(n):
        if i == 0:
            print(dp2[1] + abs(a[1]))
        elif i == n - 1:
            print(dp1[n - 2] + abs(a[n - 2]))
        else:
            print(dp1[i - 1] + dp2[i + 1] + abs(a[i - 1] - a[i + 1]))

if __name__ == "__main__":
    main()
