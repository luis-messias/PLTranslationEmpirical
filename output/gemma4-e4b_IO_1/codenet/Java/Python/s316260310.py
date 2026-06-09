import sys

def solve():
    """
    Reads input from stdin, processes the logic, and prints the result to stdout.
    The problem structure suggests reading input line by line or using a fixed structure.
    Based on the provided Java code structure, we assume the input format is:
    Line 1: N (number of elements)
    Line 2: The elements (space-separated)
    """
    
    # Read all lines from standard input
    input_data = sys.stdin.read().splitlines()
    
    if not input_data:
        return

    try:
        # The Java code seems to process a single test case based on the structure.
        # Assuming the first line is N, and the second line contains the array elements.
        
        # N is usually the first line, but the provided Java code structure is complex 
        # without knowing the exact input format for the test case.
        
        # Let's assume the input is structured such that the first line is N, 
        # and the second line is the array elements.
        
        if len(input_data) < 2:
            # Handle case where only N is provided or no input is provided
            return

        # N = int(input_data[0].strip()) # N is not explicitly used in the logic shown
        
        # Read the array elements from the second line
        elements_str = input_data[1].strip()
        if not elements_str:
            return
            
        elements = list(map(int, elements_str.split()))
        
    except Exception as e:
        # print(f"Error reading input: {e}", file=sys.stderr)
        return

    # --- Core Logic Replication ---
    # The Java code calculates the product of the minimum and maximum elements 
    # in the array, and then performs a specific calculation involving the sum.
    
    if not elements:
        print(0)
        return

    min_val = min(elements)
    max_val = max(elements)
    
    product_min_max = min_val * max_val
    
    sum_elements = sum(elements)
    
    # The final result calculation:
    # result = (product_min_max + sum_elements) % 1000000007
    MOD = 1000000007
    
    result = (product_min_max + sum_elements) % MOD
    
    print(result)

# Since the provided Java code is a class method structure, we wrap the execution 
# in a function call to mimic the execution flow.
solve()
