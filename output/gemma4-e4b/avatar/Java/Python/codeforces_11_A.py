import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first element, D is the second
    n = int(data[0])
    d = int(data[1])
    
    # The remaining elements are the array nums
    nums = [int(x) for x in data[2:2+n]]
    
    result = 0
    
    # Iterate from the second element (index 1)
    for i in range(1, n):
        # Calculate a = nums[i-1] - nums[i]
        a = nums[i-1] - nums[i]
        
        if a >= 0:
            # Calculate steps: a / d + 1. Use integer division (//)
            steps = a // d + 1
            
            # Update result
            result += steps
            
            # Update nums[i]
            nums[i] += steps * d
            
    print(result)

if __name__ == "__main__":
    solve()