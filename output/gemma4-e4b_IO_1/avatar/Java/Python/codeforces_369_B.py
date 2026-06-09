import sys

def get_points(n, k, l, r, s_all, sk):
    ans = [l] * n
    
    # sAll -= sk + ( n - k ) * l ;
    s_all -= sk + (n - k) * l
    
    # sk -= k * l ;
    sk -= k * l
    
    # while ( sk > 0 ) { ... }
    while sk > 0:
        idx = n - 1
        while sk > 0 and idx >= n - k:
            ans[idx - 1] += 1
            idx -= 1
            sk -= 1
            
    # while ( sAll > 0 ) { ... }
    while s_all > 0:
        idx = 0
        while s_all > 0 and idx < n - k:
            ans[idx] += 1
            idx += 1
            s_all -= 1
            
    return ans

def solve():
    # Read all 6 integers from standard input
    try:
        data = list(map(int, sys.stdin.read().split()))
    except:
        # Handle empty input case if necessary, though problem context implies input exists
        return

    if len(data) < 6:
        return

    n, k, l, r, s_all, sk = data[0], data[1], data[2], data[3], data[4], data[5]
    
    result = get_points(n, k, l, r, s_all, sk)
    
    print(*(result))

solve()
