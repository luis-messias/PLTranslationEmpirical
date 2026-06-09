import sys

def solve():
    input_data = sys.stdin.read().split()
    iterator = iter(input_data)
    
    N = int(next(iterator))
    arr = [int(next(iterator)) for _ in range(N)]
    
    sorted_arr = sorted(arr)
    total = N * (N + 1) // 2
    
    l, r = 0, N - 1
    
    while l < r:
        mid = l + (r - l) // 2
        target = sorted_arr[mid]
        
        bit = [0] * (2 * N + 2)
        
        # Initialize BIT
        x = N + 1
        while x < 2 * N + 2:
            bit[x] += 1
            x += x & -x
        
        cur = 0
        cnt = 0
        
        for x in arr:
            cur += 1 if x <= target else -1
            
            # Update BIT
            i = cur + N + 1
            while i < 2 * N + 2:
                bit[i] += 1
                i += i & -i
            
            # Query BIT
            i = cur + N
            while i > 0:
                cnt += bit[i]
                i -= i & -i
        
        if cnt >= total // 2 + 1:
            r = mid
        else:
            l = mid + 1
    
    print(sorted_arr[l])

if __name__ == "__main__":
    solve()
