import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    if not data:
        return

    data_ptr = 0

    def get_next_int():
        nonlocal data_ptr
        if data_ptr < len(data):
            val = int(data[data_ptr])
            data_ptr += 1
            return val
        return None

    # 1. Read N and M
    N = get_next_int()
    M = get_next_int()

    # 2. Initialize a
    a = [0] * N

    # 3. Process M updates
    for i in range(M):
        k = get_next_int()
        for j in range(k):
            s = get_next_int()
            # s is 1-based index, a is 0-based
            s_idx = s - 1
            # a[s_idx] = a[s_idx] | (1 << i)
            a[s_idx] = a[s_idx] | (1 << i)

    # 4. Process p
    p = 0
    for i in range(M):
        x = get_next_int()
        # p |= (x << i)
        p |= (x << i)

    # 5. Calculate ans
    ans = 0
    # Iterate through all 2^N subsets (s_mask)
    for s_mask in range(1 << N):
        t = 0
        # Check bits 0 to N-1
        for i in range(N):
            # if ((s_mask >> i) & 1) == 1:
            if (s_mask >> i) & 1:
                t ^= a[i]
        
        if p == t:
            ans += 1

    print(ans)

if __name__ == "__main__":
    solve()