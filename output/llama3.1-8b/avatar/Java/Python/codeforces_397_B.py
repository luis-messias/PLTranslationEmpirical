import sys

MOD = 1000000007

def main():
    t = int(input())
    while t > 0:
        n, a, b = map(int, input().split())
        if n < a:
            print("No")
            continue
        if a == b:
            if n % a == 0:
                print("Yes")
            else:
                print("No")
            continue
        x = (b // (b - a))
        if n > x * a:
            print("Yes")
            continue
        low, high = 1, x + 1
        ans = 1
        while low <= high:
            mid = (low + high) // 2
            if mid * a < n:
                low = mid + 1
            else:
                ans = mid
                high = mid - 1
        if n > (ans - 1) * b and n < ans * a:
            print("No")
        else:
            print("Yes")
        t -= 1

if __name__ == "__main__":
    main()