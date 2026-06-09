import sys

def solve():
    # Read the entire input line from stdin
    try:
        s = sys.stdin.read().strip()
    except:
        # Handle case where input might be empty or error during read
        return

    if not s:
        return

    result = []
    for char in s:
        if char == '0':
            result.append('0')
        elif char == '1':
            result.append('1')
        elif char == 'B':
            # If 'B', remove the last character if the result is not empty
            if result:
                result.pop()
        # Other characters are implicitly ignored based on the Java switch structure

    # The Java code prints the resulting string d.
    print("".join(result))

if __name__ == "__main__":
    solve()
