import sys
def main():
    n = int(input())
    d = 0
    for _ in range(n):
        numbers = list(map(int, input().split()))
        d += sum(num % 2 for num in numbers)
    print("YES" if d % 2 == 0 else "NO")
if __name__ == "__main__":
    main()
