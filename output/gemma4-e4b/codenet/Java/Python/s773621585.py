import sys

def solve():
    # Read all input lines to simulate sequential reading behavior of Scanner
    lines = sys.stdin.read().splitlines()
    
    if not lines:
        print(0)
        return

    # 1. Read N (the first line)
    try:
        n = int(lines[0])
    except ValueError:
        n = 0
    
    # 2. Consume the line corresponding to 'str' (the second line of input)
    # This line is read but ignored in the map logic, mimicking the Java code.
    if len