import sys

def solve():
    # Read all input lines
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # The first element is 'a' (the size)
    try:
        a = int(input_data[0])
    except ValueError:
        return

    # The remaining elements are the array 'ar'
    if len(input_data) < a + 1:
        return
        
    ar = [int(x) for x in input_data[1:a+1]]
    
    N = len(ar)

    for i in range(N):
        # Calculate max
        # max = Math.max(ar[i] - ar[0], ar[ar.length - 1] - ar[i])
        max_val = max(ar[i] - ar[0], ar[N - 1] - ar[i])

        # Calculate min
        if i == 0:
            # min = ar[i + 1] - ar[i]
            min_val = ar[i + 1] - ar[i]
        elif i == N - 1:
            # min = ar[i] - ar[i - 1]
            min_val = ar[i] - ar[i - 1]
        else:
            # min = Math.min(ar[i] - ar[i - 1], ar[i + 1] - ar[i])
            diff1 = ar[i] - ar[i - 1]
            diff2 = ar[i + 1] - ar[i]
            min_val = min(diff1, diff2)
        
        print(f"{min_val} {max_val}")

solve()