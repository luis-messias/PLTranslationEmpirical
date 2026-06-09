import sys

def solve():
    # Read all input tokens from standard input
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # N is the first element
    n = int(input_data[0])
    # S is the second element
    s = int(input_data[1])
    
    max_sum = 0
    
    # The pairs (f, t) start from index 2
    for i in range(n):
        # Calculate indices for f and t
        f_index = 2 + 2 * i
        t_index = 3 + 2 * i
        
        # Read f and t
        f = int(input_data[f_index])
        t = int(input_data[t_index])
        
        current_sum = f + t
        if current_sum > max_sum:
            max_sum = current_sum
            
    # Output max(max_sum, S)
    print(max(max_sum, s))

if __name__ == "__main__":
    solve()