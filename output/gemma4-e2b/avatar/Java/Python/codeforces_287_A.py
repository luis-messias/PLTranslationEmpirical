import sys

def solve():
    # Read 4 strings from standard input
    str_list = []
    for _ in range(4):
        line = sys.stdin.readline().strip()
        if line:
            str_list.append(line)
        else:
            # Handle potential premature EOF if input is less than 4 lines
            return

    if len(str_list) < 4:
        # Not enough input to proceed
        print("NO")
        return

    # Initialization based on Java:
    # u = -1, i = -1, yes = 0
    u = -1
    i = -1