import sys

def check(x, n, a, k):
    tot = 0
    for i in range(n):
        now = a[i]
        l = 0
        r = n
        
        if now >= 0:
            # Find count of a[c] such that now * a[c] < x
            # This finds the index l such that a[0]...a[l-1] satisfy the condition
            while l < r:
                c = (l + r) // 2
                if now * a[c] < x:
                    l = c + 1
                else:
                    r = c
            tot += l
        else:
            # Find count of a[c] such that now * a[c] >= x
            # This finds the index l such that a[l]...a[n-1] satisfy the condition
            while l < r:
                c = (l + r) // 2
                if now * a[c] >= x:
                    l = c + 1
                else:
                    r = c
            tot += (n - l)
            
        # Adjustment based on a[i]^2 < x
        if a[i] * a[i] < x:
            tot -= 1
            
    # The original Java code checks if tot / 2 < k
    return tot // 2 < k

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    n = int(data[0])
    # K is the second element
    k = int(data[1])
    
    # Array A starts from the third element
    a = [int(x) for x in data[2:]]
    
    # Sort A
    a.sort()
    
    # Binary search range for the answer L
    # INF is set to 10^18 + 1, matching the Java logic's intent for bounds
    INF = 10**18 + 1
    l = -INF
    r = INF
    
    # Binary search for the minimum L such that check(L) is true
    # The loop condition l + 1 < r ensures we find the smallest l satisfying the condition