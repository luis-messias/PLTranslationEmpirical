import sys

def solve():
    # Read all lines from standard input
    input_data = sys.stdin.read().splitlines()
    
    if not input_data:
        return

    # Line 1: arr (the sequence of characters)
    arr = input_data[0]
    N = len(arr)
    
    # Line 2: K (number of test cases)
    try:
        K = int(input_data[1])
    except (IndexError, ValueError):
        return

    # Lines 3 onwards: input strings
    input_lines = input_data[2:2+K]
    
    res = 0
    
    for input_str in input_lines:
        a = 0
        b = 0
        
        # Iterate through the sequence arr
        for char_arr in arr:
            if char_arr == input_str[0]:
                a += 1
            elif char_arr == input_str[1]:
                b += 1
            else:
                # Separator found
                res += min(a, b)
                a = 0
                b = 0
        
        # After processing the entire array, add the final segment's contribution
        res += min(a, b)

    print(res)

if __name__ == "__main__":
    solve()
