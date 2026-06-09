import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # Input parsing
    # data[0] is N
    # data[1] is K
    n = int(data[0])
    k = int(data[1])
    
    # The array elements start from index 2 up to 2 + n - 1
    arr = [int(x) for x in data[2:2 + n]]
    
    # The queries (l, r) start after the array elements
    query_data = data[2 + n:]
    
    # Count 1s (o) and non-1s (e)
    o = arr.count(1)
    e = n - o
    
    result = []
    
    # Process K queries
    # Queries are in pairs (l, r)
    for i in range(k):
        # l is at index 2*i
        l = int(query_data[2 * i])
        # r is at index 2*i + 1
        r = int(query_data[2 * i + 1])
        
        length = r - l + 1
        
        if length % 2 == 1:
            result.append("0\n")
        else:
            half_length = length // 2
            # Check if half_length <= o AND half_length <= e
            if half_length <= o and half_length <= e:
                result.append("1\n")
            else:
                result.append("0\n")
                
    sys.stdout.write("".join(result))

solve()