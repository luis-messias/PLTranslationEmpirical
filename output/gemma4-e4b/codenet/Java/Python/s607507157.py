import sys

def main():
    try:
        # Read the integer input from standard input
        n = int(sys.stdin.read().strip())
    except:
        # Handle case where no input is provided (though usually competitive programming environments guarantee input)
        return

    # The original Java code logic:
    # if (n % 10 == 9 || n / 10 == 9)
    # Note: In Java, '||' is the logical OR.
    # The condition checks if:
    # 1. The last digit is 9 (n % 10 == 9)
    # OR
    # 2. Integer division of n by 10 is 9 (n / 10 == 9, which means n is between 90 and 99 inclusive, but since it's integer division, it means n is in the range [90, 99] if we assume standard integer behavior, or more precisely, n/10 = 9 means 90 <= n < 100).

    # Python equivalent for the logic:
    if (n % 10 == 9) or (n // 10 == 9):
        print("Yes")
    else:
        print("No")

if __name__ == "__main__":
    main()