import sys

# Read all input tokens
input_data = sys.stdin.read().split()

if not input_data:
    # Handle empty input
    exit()

# The first element is n
n = int(input_data[0])
# The remaining elements are the numbers
nums = [int(x) for x in input_data[1:]]

min_abs = float('inf')
count_negatives = 0
sum_abs = 0

for num in nums:
    abs_num = abs(num)
    sum_abs += abs_num
    
    # Calculate the minimum absolute value encountered
    if abs_num < min_abs:
        min_abs = abs_num
        
    # Count negative numbers
    if num < 0:
        count_negatives += 1

# Determine the result based on the parity of count_negatives
if count_negatives % 2 == 0:
    result = sum_abs
else:
    # sum - (min * 2)
    result = sum_abs - (min_abs * 2)

print(result)