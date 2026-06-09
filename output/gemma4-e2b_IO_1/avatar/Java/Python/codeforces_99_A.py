import sys

def solve():
    # Read the entire line of input
    try:
        line = sys.stdin.readline().strip()
    except:
        return

    if not line:
        return

    # Find the index of the dot
    try:
        dot_index = line.index('.')
    except ValueError:
        # If no dot is found, we stop here, although the Java code structure implies a dot exists.
        return

    # Check the condition: str[dotIndex - 1] == '9'
    # We must ensure dot_index > 0
    if dot_index > 0 and line[dot_index - 1] == '9':
        print("GOTO Vasilisa.")

# Execute the solution
solve()
