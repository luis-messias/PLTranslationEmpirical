import sys

def solve():
    # Read input from stdin
    try:
        # Read the single integer x
        x = int(sys.stdin.readline())
    except:
        # Handle case where input might be empty
        return

    count = 0
    tmp = x
    x_current = 0

    # The loop structure from the Java code
    while x_current != 360:
        x_current = x_current + tmp
        if x_current > 360:
            x_