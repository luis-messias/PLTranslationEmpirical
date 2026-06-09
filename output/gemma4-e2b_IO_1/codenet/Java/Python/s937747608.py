import sys

try:
    # Read all space-separated integers from standard input
    data = sys.stdin.read().split()
    if len(data) >= 4:
        a = int(data[0])
        b = int(data[1])
        c = int(data[2])
        d = int(data[3])

        if a * b >= c * d:
            print(a * b)
        else:
            print(c * d)
except:
    # Handle case where input reading fails or is incomplete
    pass
