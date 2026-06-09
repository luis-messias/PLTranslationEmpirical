def check_leap(y):
    return y % 400 == 0 or (y % 4 == 0 and y % 100 != 0)

import sys

try:
    # Read input y
    y = int(sys.stdin.readline())
except:
    # Handle potential empty input or non-integer input
    sys.exit()

leap = check_leap(y)
sum_val = 0

i = y + 1
while True:
    # Calculate the number of days for year i
    if check_leap(i):
        sum_val += 366
    else:
        sum_val += 365
    
    # Check if the accumulated sum is divisible by 7
    if sum_val % 7 == 0:
        # Check the condition: ((check_leap(i) &&
