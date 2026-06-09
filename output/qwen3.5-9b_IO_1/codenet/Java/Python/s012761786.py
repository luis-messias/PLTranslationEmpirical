import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    a = int(input_data[1])
    b = int(input_data[2])

    sa = abs(a - b)

    ans = 0

    if sa % 2 == 0:
        ans = sa // 2
    else:
        AAA = min(n - a, a - 1)
        BBB = min(n - b, b - 1)
        ans = min(AAA, BBB)
        sa -= 1
        ans += 1
        ans += sa // 2

    print(ans)

if __name__ == "__main__":
    main()
