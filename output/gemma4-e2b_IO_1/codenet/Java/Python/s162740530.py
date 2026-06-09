import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N and M are the first two inputs
    n = int(data[0])
    m = int(data[1])
    
    # The remaining elements are the array A elements, starting from index 2 in data
    # We expect M elements for A.
    if len(data) < 2 + m:
        # Handle insufficient input if necessary, though typically assumed correct in CP context
        return
        
    a = [0] * (m + 1)
    # Read a[1] through a[m]
    for i in range(1, m + 1):
        a[i] = int(data[i + 1])

    # cnt array initialization (size n+1)
    cnt = [0] * (n + 1)
    cnt[0] = 1
    MOD = 1000000007

    # --- Logic replication ---

    # Initialize num pointer for accessing a[num]
    num = 1
    
    # Calculate cnt[1] based on a[1]
    if m > 0:
        if a[1] == 1:
            cnt[1] = 0
            if num < m:
                num += 1
        else:
            cnt[1] = 1
    else:
        # If m=0, cnt[1] = 1
        cnt[1] = 1

    # Dynamic programming calculation
    # Loop runs from i=2 up to n (since cnt has size n+1)
    for i in range(2, n + 1):
        # cnt[i] = cnt[i - 2] + cnt[i - 1]
        cnt[i] = cnt[i - 2] + cnt[i - 1]
        cnt[i] %= MOD
        
        # Check the condition based on a[num]
        if m > 0:
            # Check if i matches the index a[num]
            if i == a[num]:
                cnt[i] = 0
                # Update num if necessary
                if num < m:
                    num += 1

    # Output cnt[n]
    print(cnt[n])

solve()
