def check_leap(y):
    return y % 400 == 0 or (y % 4 == 0 and y % 100 != 0)

import sys

# Read input from stdin
try:
    y = int(sys.stdin.readline())
except:
    # Handle empty input case if necessary
    exit()

leap = check_leap(y)
sum_val = 0

i = y + 1
while True:
    if check_leap(i):
        sum_val += 366
    else:
        sum_val += 365
    
    if sum_val % 7 == 0:
        # Check the condition: ((check_leap(i) AND leap) OR (NOT check_leap(i) AND NOT leap))
        if (check_leap(i) == leap):
            print(i)
            sys.exit()
        else:
            continue
    
    i += 1