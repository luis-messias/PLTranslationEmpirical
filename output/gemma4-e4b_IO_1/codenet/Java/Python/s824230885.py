import sys

def solve():
    # Read all input lines
    input_data = sys.stdin.read().splitlines()
    
    if not input_data:
        return

    # N is on the first line
    try:
        N = int(input_data[0].strip())
    except ValueError:
        return

    # The list of integers is on the second line
    if len(input_data) < 2:
        return
        
    try:
        list_str = input_data[1].strip().split()
        list_data = [int(x) for x in list_str]
    except ValueError:
        return

    # We only care about the first N elements
    list_data = list_data[:N]

    # Core logic: Count elements that are greater than or equal to the current maximum
    max_val = 0
    output_count = 0
    
    for element in list_data:
        if max_val <= element:
            max_val = element
            output_count += 1
            
    print(output_count)

if __name__ == "__main__":
    solve()
