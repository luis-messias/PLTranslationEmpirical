import sys

def solve():
    # Read input from stdin
    try:
        line1 = sys.stdin.readline().strip()
        line2 = sys.stdin.readline().strip()
    except EOFError:
        return

    if not line1 or not line2:
        return

    # Parse line 1 (x)
    try:
        h1_str, m1_str = line1.split(':')
        h1 = int(h1_str)
        m1 = int(m1_str)
    except ValueError:
        # Handle potential parsing errors if input format is strictly guaranteed, this might not be necessary
        return

    # Parse line 2 (y)
    try:
        h2_str, m2_str = line2.split(':')
        h2 = int(h2_str)
        m2 = int(m2_str)
    except ValueError:
        return

    # Calculate the result based on the Java logic: x.minusHours(y.getHour()).minusMinutes(y.getMinute())
    # x = h1:m1, y = h2:m2
    
    # Calculate the difference in total minutes
    # x in minutes: h1 * 60 + m1
    # y in minutes: h2 * 60 + m2
    
    x_minutes = h1 * 60 + m1
    y_minutes = h2 * 60 + m2
    
    # Calculate the difference in minutes
    diff_minutes = x_minutes - y_minutes
    
    # Convert the difference back to hours and minutes
    # Since the Java code uses LocalTime subtraction, we need to handle potential negative results 
    # if the subtraction crosses midnight, although for this specific problem structure, 
    # the result is expected to be positive and within the 24-hour cycle.
    
    # Total minutes in a day
    MINUTES_PER_DAY = 24 * 60
    
    # Ensure the result is positive and within the 24-hour cycle (modulo arithmetic)
    # Python's % operator handles negative numbers correctly for mathematical modulo if the divisor is positive.
    result_minutes = diff_minutes % MINUTES_PER_DAY
    
    result_h = result_minutes // 60
    result_m = result_minutes
