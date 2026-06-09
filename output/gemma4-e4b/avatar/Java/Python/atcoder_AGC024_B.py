import sys
import math

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    N = int(data[0])
    
    # P contains the permutation values, adjusted to be 0-indexed
    P = [int(x) - 1 for x in data[1:N+1]]

    # 1. Create the map: value -> index
    # value_to_index[v] stores the original index i where value v was found
    value_to_index = {}
    for i in range(N):
        value_to_index[P[i]] = i

    # 2. Find break points (nglist)
    # A break point occurs at index i if value i appears after value i+1
    nglist = []
    for i in range(N - 1):
        # Check if index of i > index of i+1
        if value_to_index[i] > value_to_index[i+1]:
            nglist.append(i)

    # 3. Handle empty nglist
    if not nglist:
        print(0)
        return

    # 4. Calculate minimum answer
    L = nglist
    
    # Initialize ans with the minimum of the two endpoints
    # Left side: N - L[0] - 1
    ans = N - L