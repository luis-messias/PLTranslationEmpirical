import sys

def solve():
    # Read all input data from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # N = input_data[0], K = input_data[1]
    N = int(input_data[0])
    K = int(input_data[1])
    
    # A = input_data[2:]
    A = [int(x) for x in input_data[2:]]

    # 1. Calculate Prefix Sums
    # cumsum[i] stores the sum of A[0]...A[i-1]
    cumsum = [0] * (N + 1)
    for i in range(N):
        cumsum[i + 1] = cumsum[i] + A[i]

    # 2. Calculate all subarray sums (list b) and find max sum
    b = []
    max_sum = 0
    
    for i in range(N):
        for j in range(i, N):
            # Sum A[i]...A[j] = cumsum[j+1] - cumsum[i]
            current_sum = cumsum[j + 1] - cumsum[i]
            b.append(current_sum)
            if current_sum > max_sum:
                max_sum = current_sum

    # 3. Bitmask Filtering
    
    # Determine the highest set bit of max_sum
    if max_sum == 0:
        mask = 0
    else:
        # Equivalent to Long.highestOneBit(max_sum)
        mask = 1 << (max_sum.bit_length() - 1)
    
    while mask > 0:
        tmp = []
        for e in b:
            # Check if the bit corresponding to mask is set
            if (e & mask) != 0:
                tmp.append(e)
        
        if len(tmp) >= K:
            b = tmp
        
        # Shift mask right
        mask >>= 1
    
    # 4. Output Result
    if len(b) < K:
        print(0)
    else:
        # Calculate bitwise AND of all elements in b
        # Since b is guaranteed non-empty here (as len(b) >= K >= 1)
        ans = b[0]
        for i in range(1, len(b)):
            ans &= b[i]
        
        print(ans)

if __name__ == "__main__":
    solve()