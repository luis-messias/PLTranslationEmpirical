import sys
import math

def solve():
    # Read all input tokens from standard input
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # Process input tokens in pairs (n, m)
    i = 0
    results = []
    while i < len(input_data):
        try:
            # Read n and m as integers (Python handles large integers automatically)
            n = int(input_data[i])
            m = int(input_data[i+1])
        except IndexError:
            break
        
        i += 2
        
        # Core logic translation from Java solve method
        
        if n == 0 or n == m:
            results.append(0)
            continue
        
        if n > m:
            # The Java logic simplifies to calculating n_final = n % m
            n_final = n % m
            
            # Result = min(m - n_final, n_final)
            result = min(m - n_final, n_final)
            results.append(result)
            continue
        
        # n < m
        # Result = min(m - n, n)
        result = min(m - n, n)
        results.append(result)

    sys.stdout.write('\n'.join(map(str, results)) + '\n')

if __name__ == "__main__":
    solve()
