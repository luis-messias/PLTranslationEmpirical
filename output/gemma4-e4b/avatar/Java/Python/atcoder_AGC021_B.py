import math
import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    N = int(data[0])
    
    x = [0] * N
    y = [0] * N
    
    # Read coordinates (N pairs)
    data_index = 1
    for i in range(N):
        x[i] = int(data[data_index])
        y[i] = int(data[data_index + 1])
        data_index += 2

    # Loop over each point i
    for i in range(N):
        thetas = []
        
        # Calculate angles relative to point i
        for j in range(N):
            if i == j:
                continue
            
            # math.atan2(y_diff, x_diff)
            theta = math.atan2(y[j] - y[i], x[j] - x[i])
            thetas.append(theta)
        
        # Sort the angles
        thetas.sort()
        
        # Handle circular nature: append the first angle + 2*pi
        if thetas:
            thetas.append(thetas[0] + 2 * math.pi)
        
        # Calculate maximum gap
        ans = 0.0
        # The list now has N elements, defining N-1 gaps
        for k in range(len(thetas) - 1):
            # Gap calculation: (theta_{k+1} - theta_k) - pi
            gap = thetas[k+1] - thetas[k] - math.pi
            ans = max(ans, gap)
        
        # Output the result for point i
        print(f"{ans / (math.pi * 2)}")

if __name__ == "__main__":
    solve()