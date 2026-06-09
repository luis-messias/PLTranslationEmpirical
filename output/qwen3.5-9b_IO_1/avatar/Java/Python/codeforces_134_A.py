import sys

def main():
    n = int(input())
    arr = list(map(int, input().split()))
    sum_val = sum(arr)
    c = 0
    sb = []
    for i in range(n):
        if (sum_val - arr[i]) % (n - 1) == 0 and (sum_val - arr[i]) // (n - 1) == arr[i]:
            c += 1
            sb.append(str(i + 1) + " ")
    print(c)
    print("".join(sb))

if __name__ == "__main__":
    main()
