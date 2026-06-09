import sys
import math

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    if not data:
        return

    # N = number of vectors (rows)
    # D = dimension (columns)
    N = int(data[0])
    D = int(data[1])
    
    # Read the matrix data
    vectors = []
    data_index = 2
    for i in range(N):
        row = []
        for j in range(D):
            row.append(int(data[data_index]))
            data_index += 1
        vectors.append(row)

    answer = 0
    
    # Iterate over all unique pairs of vectors (i, j) where i < j
    for i in range(N):
        for j in range(i + 1, N):
            dist_sq = 0
            
            # Calculate the squared Euclidean distance
            for d in range(D):
                x = vectors[i][d] - vectors[j][d]
                dist_sq += (x * x)
            
            # Calculate the actual distance
            sq = math.sqrt(dist_sq)
            
            # Check if the distance is an integer (within tolerance)
            # The Java code uses Math.abs(sq - Math.floor(sq)) < 0.001
            is_integer = abs(sq - round(sq)) < 0.001
            
            if is_integer:
                answer += 1
                
    print(answer)

if __name__ == "__main__":
    solve()