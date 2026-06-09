import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # N is the first element
        n = int(data[0])
        # nums are the next N elements
        nums = [int(x) for x in data[1:n+1]]
    except ValueError:
        # Handle malformed input
        return

    min_abs = float('inf')
    count_negatives = 0
    total_abs_sum = 0

    for num in nums:
        abs_val = abs(num)
        
        total_abs_sum += abs_val
        min_abs = min(min_abs, abs_val)
        
        if num < 0:
            count_negatives += 1

    # Determine the output based on the parity of count_negatives
    if count_negatives % 2 == 0:
        print(total_abs_sum)
    else:
        # sum - (min * 2)
        print(total_abs_sum - (min_abs * 2))

if __name__ == "__main__":
    solve()