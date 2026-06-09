import sys

def solve():
    # Read all input tokens
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # N = input_data[0], M = input_data[1]
    n = int(input_data[0])
    m = int(input_data[1])
    
    # The remaining elements are the array contents
    arr_elements = [int(x) for x in input_data[2:]]
    
    # gen array (size 11, indices 0 to 10)
    gen = [0] * 11
    
    # Populate gen
    for x in arr_elements:
        if 0 <= x < 11:
            gen[x] += 1
            
    # Calculate ans
    ans = 0
    for i in range(1, m + 1):
        for k in range(1, m + 1):
            if i != k:
                ans += gen[i] * gen[k]
                
    # Output ans / 2 (integer division)
    print(ans // 2)

solve()