import sys

try:
    # Read a and b from standard input
    # Assuming input is provided sequentially, one number per line or space separated.
    # Reading two integers sequentially as in the Java code.
    a = int(sys.stdin.readline())
    b = int(sys.stdin.readline())
except:
    # Handle case where input might fail
    sys.exit()

if a > 0:
    print("Positive")
elif b >= 0:
    print("Zero")
elif (b - a + 1) % 2 == 0:
    print("Positive")
else:
    print("Negative")