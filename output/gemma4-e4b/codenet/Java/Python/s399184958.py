import sys

def solve():
    try:
        # Read all space-separated integers from standard input
        data = sys.stdin.read().split()
        if len(data) < 3:
            return

        A = int(data[0])
        B = int(data[1])
        C = int(data[2])

        if A == B and B == C:
            print("Yes")
        else:
            print("No")
    except Exception:
        # Handle potential empty or malformed input gracefully
        pass

solve()