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
        for x in range(N + 1, 2 * N + 2):
            bit[x] += 1
        
        cur = 0
        cnt = 0
        
        for x in arr:
            cur += 1 if x <= target else -1
            
            # Update BIT
            for i in range(cur + N + 1, 2 * N + 2):
                i += i & -i
                bit[i] += 1
            
            # Query BIT
            for i in range(cur + N, 0, -1):
                i -= i & -i
                cnt += bit[i]
        
        if cnt >= total // 2 + 1:
            r = mid
        else:
            l = mid + 1
    
    print(sorted_arr[l])

if __name__ == "__main__":
    solve()