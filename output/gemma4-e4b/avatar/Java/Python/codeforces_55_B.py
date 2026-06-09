import sys

# Set up global minimum variable
min_val = float('inf')

def util(arr, ops, idx):
    global min_val
    
    if idx == 3:
        # Base case: 3 operations performed. The result is the first element.
        min_val = min(min_val, arr[0])
        return

    n = len(arr)
    
    # Iterate over all pairs (i, j)
    for i in range(n):
        for j in range(i + 1, n):
            
            # 1. Construct the next array 'a' (excluding arr[i] and arr[j])
            a = []
            for k in range(n):
                if k != j and k != i:
                    a.append(arr[k])
            
            # 2. Calculate the result 'res'
            op = ops[idx]
            
            if op == "+":
                res = arr[i] + arr[j]
            else:
                # Assuming '*' if not '+'
                res = arr[i] * arr[j]
            
            # 3. Add the result to 'a'
            a.append(res)
            
            # 4. Recursive call
            util(a, ops, idx + 1)

def solve():
    global min_val
    
    # Read all input tokens
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first 4 tokens are the initial numbers (longs)
    initial_arr = [int(x) for x in input_data[:4]]
    
    # The next 3 tokens are the operators (strings)
    ops = input_data[4:7]
    
    # Reset global minimum
    min_val = float('inf')
    
    # Start the recursion
    util(initial_arr, ops, 0)
    
    print(min_val)

if __name__ == "__main__":
    solve()