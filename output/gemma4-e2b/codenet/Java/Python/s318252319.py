import sys

def solve():
    # Read the input string (assuming it's a single token as per sc.next())
    try:
        s = sys.stdin.readline().strip()
    except:
        return

    if not s:
        return

    # Extract the last character and convert it to an integer
    # s[-1] gets the last character
    n = int(s[-1])

    if n == 3:
        print("bon")
    elif n == 0 or n == 1 or n == 6 or n == 8:
        print("pon")
    else:
        print("hon")

solve()