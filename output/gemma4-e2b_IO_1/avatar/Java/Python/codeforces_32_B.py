import sys

def solve():
    # Read the input line. In the Java code, in.next() reads the next token.
    # We read the entire input line as a string.
    try:
        # Read all input and strip potential trailing whitespace/newlines
        line = sys.stdin.read().strip()
    except:
        line = ""

    if not line:
        return

    s = False
    result = []

    for char in line:
        if char == '.':
            if s:
                result.append('1')
                s = False
            else:
                result.append('0')
        else:
            if s:
                result.append('2')
                s = False
            else:
                s = True
    
    print("".join(result))

solve()
