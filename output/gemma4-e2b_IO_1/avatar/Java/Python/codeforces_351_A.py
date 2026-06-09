import sys
import math

def solve():
    # Read all input lines
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first element is N
    try:
        n = int(input_data[0])
    except ValueError:
        # Handle case where input might be malformed or empty
        return

    if len(input_data) < 2 * n + 1:
        # Not enough data provided
        return

    # The remaining elements are the 2*N numbers
    data = [float(x) for x in input_data[1:]]
    
    if len(data) != 2 * n:
        # Data mismatch
        return

    # Initialize variables based on Java logic
    sum_before = 0.0
    sum_floor = 0.0
    non_int = 0
    sum_floor_sum = 0.0
    
    # Process the 2*N numbers
    for i in range(2 * n):
        num = data[i]
        sum_before += num
        
        # Check if the number is not an integer (i.e., has a fractional part)
        if num != math.floor(num):
            non_int += 1
            
        # Sum of the floor of the numbers
        sum_floor_sum += math.floor(num)

    # In the Java code, 'sum' was calculated as sum of floor(num)
    sum_floor = sum_floor_sum
    
    # Calculate max_sum and min_sum
    # max_sum = Math.min(n, non_int) + sum (where sum is sum_floor)
    max_sum = min(n, non_int) + sum_floor
    
    # min_sum = Math.max(0, non_int - n) + sum (where sum is sum_floor)
    min_sum = max(0, non_int - n) + sum_floor
    
    # Calculate ans based on comparisons with sum_before
    ans = 0.0
    
    if min_sum > sum_before:
        ans = min_sum - sum_before
    elif max_sum < sum_before:
        ans = sum_before - max_sum
