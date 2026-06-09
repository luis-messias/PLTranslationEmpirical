import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is N
    try:
        n = int(data[0])
    except ValueError:
        return

    # Initialize count array (size n+1, indexed 1 to n)
    count_arr = [0] * (n + 1)

    # Iterate x, y, z from 1 to 100
    for x in range(1, 101):
        for y in range(1, 101):
            for z in range(1, 101):
                # Calculate value = x*x + y*y + z*z + x*y + x*z + y*z
                value = x*x + y*y + z*z + x*y + x*z + y*z
                
                if value > n:
                    # Optimization: if value exceeds n, no need to check larger z for fixed x, y
                    break 
                
                count_arr[value] += 1

    # Output results for indices 1 to n
    output = []
    for i in range(1, n + 1):
        output.append(str(count_arr[i]))
    
    sys.stdout.write('\n'.join(output) + '\n')

if __name__ == "__main__":
    solve()