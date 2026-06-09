import sys

try:
    # Read a, b, and c sequentially
    a = int(sys.stdin.readline())
    b = int(sys.stdin.readline())
    c = int(sys.stdin.readline())
except:
    # Handle case where input might fail (e.g., empty input)
    sys.exit()

if a < b and b < c and a < c:
    print("Yes")
else:
    print("No")