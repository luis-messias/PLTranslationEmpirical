from datetime import datetime, timedelta
import sys

def solve():
    # Read the two time strings from standard input
    lines = sys.stdin.read().splitlines()
    if len(lines) < 2:
        return

    s_str = lines[0]
    t_str = lines[1]

    # Parse time strings
    try:
        x_h, x_m = map(int, s_str.split(':'))
        y_h, y_m = map(int, t_str.split(':'))
    except ValueError:
        return

    # 1. Create the starting datetime object (x)
    # We use an arbitrary date (2000/1/1) since we only care about time arithmetic.
    start_time = datetime(2000, 1, 1, x_h, x_m)

    # 2. Calculate the duration to subtract (y's time components)
    duration_to_subtract = timedelta(hours=y_h
