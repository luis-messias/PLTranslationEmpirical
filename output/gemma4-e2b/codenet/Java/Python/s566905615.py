import sys

try:
    # Read a, b, and c from standard input
    a = int(sys.stdin.readline())
    b = int(sys.stdin.readline())
    c = int(sys.stdin.readline())

    # Check the condition
    if a + b >= c:
        answer = "Yes"
    else:
        answer = "No"

    # Print the result
    print(answer)
except EOFError:
    # Handle case where input might be empty if run interactively without proper input
    pass
except ValueError:
    # Handle case where input is not an integer
    pass