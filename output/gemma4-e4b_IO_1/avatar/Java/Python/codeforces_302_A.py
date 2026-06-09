import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # Pointer to track current position in data list
    ptr = 0

    # Read N and K
    N = int(data[ptr])
    K = int(data[ptr+1])
    ptr += 2

    # Read array arr
    arr = [int(x) for x in data[ptr : ptr + N]]
    ptr += N

    # Calculate counts of 1s (o) and non-1s (e) based on Java logic
    o = 0
    e = 0
    for x in arr:
        if x == 1:
            o += 1
        else:
            e += 1

    results = []

    # Process K queries
    for _ in range(K):
        # Read L and R
        L = int(data[ptr])
        R = int(data[ptr+1])
        ptr += 2

        length = R - L + 1

        if length % 2 == 1:
            results.append("0")
        else:
            half_length = length // 2
            
            # Check condition: half_length <= o AND half_length <= e
            if half_length <= o and half_length <= e:
                results.append("1")
            else:
                results.append("0")

    sys.stdout.write('\n'.join(results) + '\n')

if __name__ == "__main__":
    solve()
