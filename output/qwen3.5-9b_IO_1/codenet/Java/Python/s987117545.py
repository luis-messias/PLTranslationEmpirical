import sys

def main():
    n, k = map(int, sys.stdin.readline().split())
    
    ans = 0
    for i in range(k, n + 2):
        max_val = i * (2 * n - i + 1) // 2
        min_val = i * (i - 1) // 2
        ans += (max_val - min_val + 1)
    
    print(ans % 1000000007)

if __name__ == "__main__":
    main()
