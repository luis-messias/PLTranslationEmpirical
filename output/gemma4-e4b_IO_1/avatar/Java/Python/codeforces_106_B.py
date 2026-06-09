import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is N
    try:
        N = int(data[0])
    except IndexError:
        # Handle case where input might be empty or malformed
        return

    # Parse the N x 4 matrix
    vec = []
    data_index = 1
    
    if len(data) < 1 + N * 4:
        # Not enough data provided
        return

    for i in range(N):
        row = [int(data[data_index]), 
               int(data[data_index+1]), 
               int(data[data_index+2]), 
               int(data[data_index+3])]
        vec.append(row)
        data_index += 4

    # Logic translation
    ans = 500
    ansprice = 20000
    
    for i in range(N):
        fl = 1
        for j in range(N):
            # Check if vec[i] is strictly dominated by vec[j] in the first three dimensions
            if (vec[i][0] < vec[j][0] and 
                vec[i][1] < vec[j][1] and 
                vec[i][2] < vec[j][2]):
                fl = 0
                break # Optimization: if dominated, no need to check further j
        
        if fl == 1:
            # Check if the fourth element is smaller than the current minimum price
            if vec[i][3] < ansprice:
                ansprice = vec[i][3]
                ans = i + 1
    
    print(ans)

if __name__ == "__main__":
    solve()
