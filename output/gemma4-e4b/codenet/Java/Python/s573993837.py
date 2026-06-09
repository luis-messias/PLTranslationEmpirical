import sys
import math

def solve():
    # Read all input tokens from standard input
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # Process input tokens in pairs (n, m)
    i = 0
    while i < len(input_data):
        try:
            # Read n and m as long integers
            n = int(input_data[i])
            m = int(input_data[i+1])
        except IndexError:
            # Should not happen if input is well-formed
            break
        
        i += 2
        
        # Core logic translation from Java solve method
        
        if n == 0 or n == m:
            print(0)
            continue
        
        if n > m:
            # Java logic: n_final = n % m
            n_final = n % m
            
            # Result = min(m - n_final, n_final)
            result = min(m - n_final, n_final)
            print(result)
            continue
        
        # n < m
        # Result = min(m - n, n