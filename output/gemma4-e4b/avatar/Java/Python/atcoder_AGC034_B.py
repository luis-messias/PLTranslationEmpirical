import re
import sys

def solve():
    # Read the single token input, mimicking Scanner.next()
    try:
        # Read the first line and strip whitespace
        s = sys.stdin.readline().strip()
    except:
        s = ""

    # Replace all occurrences of "BC" with "D"
    s = re.sub("BC", "D", s)

    cnt = 0
    tmp = 0
    
    for char in s:
        if char == 'A':
            tmp += 1
        elif char == 'D':
            cnt += tmp
        else:
            # If the character is anything else (B, C, etc.)
            tmp = 0
            
    print(cnt)

if __name__ == "__main__":
    solve()