import sys
import math

def solve():
    # Read all input lines
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N and D are the first two integers
    N = int(data[0])
    D = int(data[1])
    
    # The remaining data forms the vectors
    vectors = []
    data_index = 2
    for i in range(N):
        vector = [int(x) for x in data[data_index : data_index + D]]
        vectors.append(vector)
        data_index += D

    answer = 0
    
    # Iterate over all pairs of vectors (i, j) where i < j
    for i in range(N):
        for j in range(i + 1, N):
            dist = 0
            # Calculate squared Euclidean distance
            for d in range(D):
                x = vectors[i][d] - vectors[j][d]
                dist += (x * x)
            
            # Calculate the square root
            sq = math.sqrt(dist)
            
            # Check if sq is close to an integer
            # The condition is: abs(sq - floor(sq)) < 0.001
            # This is equivalent to checking if sq is close to an integer.
            
            # We check if the fractional part is very small, or if sq is very close to an integer.
            # The Java code uses: Math.abs ( sq - Math.floor ( sq ) ) < 0.001
            
            if abs(sq - math.floor(sq)) < 0.001:
                answer += 1
                
    print(answer)

solve()
