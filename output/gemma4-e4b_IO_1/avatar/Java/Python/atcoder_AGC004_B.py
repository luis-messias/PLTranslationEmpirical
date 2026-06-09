import sys

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    N = int(data[0])
    
    # x is the second element (Java long -> Python int)
    x = int(data[1])
    
    # srimeList starts from the third element
    # Use int() conversion as Python handles large integers
    srimeList = [int(d) for d in data[2:2+N]]

    # Initialize costList: N rows, N columns
    # costList[i][k] stores C_{i, k}
    costList = [[0] * N for _ in range(N)]

    # Calculate costList
    for i in range(N):
        # k=0 case
        costList[i][0] = srimeList[i]
        
        # k=1 to N-1
        for k in range(1, N):
            # Index for the new element: (i - k) mod N
            new_srime_index = (i - k + N) % N
            
            # C_{i, k} = min(C_{i, k-1}, srimeList[new_srime_index])
            costList[i][k] = min(costList[i][k-1], srimeList[new_srime_index])

    # Calculate result list
    result = []
    for j in range(N): # j is the column index (corresponds to 'j' in Java code)
        # Calculate the sum of the j-th column: sum(costList[i][j] for i in range(N))
        column_sum = sum(costList[i][j] for i in range(N))
        
        # The result for this column j is j * x + column_sum
        result.append(j * x + column_sum)

    # Find the minimum value in result
    if result:
        print(min(result))

solve()
