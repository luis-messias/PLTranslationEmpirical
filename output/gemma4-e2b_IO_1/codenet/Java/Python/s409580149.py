import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The problem seems to be about finding the median of a set of numbers, 
    # possibly involving a specific structure or constraints not fully specified 
    # by the provided snippet alone. 
    # Based on the input structure (a single line of space-separated numbers), 
    # we assume the task is to find the median of the input numbers.
    
    try:
        # Convert the input strings to numbers (floats)
        numbers = [float(x) for x in data]
        
        if not numbers:
            return

        # Sort the numbers
        numbers.sort()
        
        n = len(numbers)
        
        # Find the median
        if n % 2 == 1:
            # Odd number of elements: median is the middle element
            median = numbers[n // 2]
        else:
            # Even number of elements: median is the average of the two middle elements
            middle1 = numbers[n // 2 - 1]
            middle2 = numbers[n // 2]
            median = (middle1 + middle2) / 2.0
            
        # Print the result
        print(f"{median}")

    except ValueError:
        # Handle case where input contains non-numeric data
        # In a competitive programming context, this might indicate an error 
        # or that the input format assumption was wrong.
        pass

# Since the provided snippet is a template for reading input, 
# we assume the execution environment will provide input via stdin.
solve()
