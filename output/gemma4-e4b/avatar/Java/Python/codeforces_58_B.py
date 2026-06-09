import sys

def solve():
    # Read the single integer input n
    try:
        n = int(sys.stdin.read().strip())
    except:
        return

    # Print n followed by a space
    print(n, end=" ")

    m = n
    
    # Loop from n-1 down to 1 (inclusive)
    for i in range(n - 1, 0, -1):
        if m % i == 0:
            # Print i followed by a space
            print(i, end=" ")
            m = i

if __name__ == "__main__":
    solve()