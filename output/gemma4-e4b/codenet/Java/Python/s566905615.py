import sys

def solve():
    # Read all inputs from standard input and split them into tokens
    data = sys.stdin.read().split()
    
    if len(data) < 3:
        # Handle case where not enough input is provided
        return

    try:
        a = int(data[0])
        b = int(data[1])
        c = int(data[2])
    except ValueError:
        # Handle case where input tokens are not valid integers
        return

    answer = "No"
    if a + b >= c:
        answer = "Yes"
    
    print(answer)

solve()