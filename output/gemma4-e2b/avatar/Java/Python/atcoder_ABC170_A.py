import sys

def solve():
    # Read the line from standard input
    try:
        line = sys.stdin.readline().strip()
    except EOFError:
        return

    if not line:
        print(0)
        return

    input_array = line.split()
    result = 0
    
    for str_val in input_array:
        result += 1
        if str_val == "0":
            break
            
    print(result)

solve()