import re
import sys

def solve():
    # Read the input string from standard input
    try:
        s = sys.stdin.read().strip()
    except EOFError:
        # Handle case where input might be empty or redirected
        return

    if not s:
        print(0)
        return

    n = len(s)
    ans = 0

    # Iterate through all 2^(n-1) masks
    # The mask determines whether to place a '+' sign at positions 0 to n-2
    num_masks = 1 << (n - 1)

    for mask in range(num_masks):
        x = str(s[0])
        
        # Construct the string x
        for i in range(n - 1):
            # Check the i-th bit of the mask
            if (mask & (1 << i)):
                # Bit is set: insert '+'
                x += "+" + s[i + 1]
            else:
                # Bit is not set: append character directly
                x += s[i + 1]
        
        # Split the string by '+'
        # re.split is used because '+' is a regex special character
        split_parts = re.split(r'\+', x)
        
        current_sum = 0
        for part in split_parts:
            # Convert each part to an integer and sum them up
            # We assume the parts are valid number strings based on the problem logic
            if part:
                current_sum += int(part)
        
        ans += current_sum

    print(ans)

solve()