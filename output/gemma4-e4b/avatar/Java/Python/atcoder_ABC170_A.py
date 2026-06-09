import sys

def solve():
    # Read all input from stdin and split it by spaces
    try:
        input_line = sys.stdin.read().strip()
    except:
        input_line = ""
    
    if not input_line:
        print(0)
        return

    input_array = input_line.split()
    
    result = 0
    for str_val in input_array:
        result += 1
        if str_val == "0":
            break
    
    print(result)

solve()