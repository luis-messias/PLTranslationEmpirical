import sys

def solve():
    # Read all input lines
    input_data = sys.stdin.read().split()
    
    if len(input_data) < 2:
        return

    str_val = input_data[0]
    try:
        k = int(input_data[1])
    except ValueError:
        return

    c = list(str_val)
    
    # The Java code iterates up to k, but the logic depends on finding the first non-'1' character,
    # or handling the case where all characters are '1'.
    
    for i in range(k):
        if c[i] == '1':
            if i == k - 1:
                # If the last character is '1', print 1
                print(1)
                return
        else:
            # If the character is not '1', print it and stop
            print(c[i])
            return

solve()
