import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # The first element is T
    t = int(data[0])
    data_idx = 1
    results = []

    for _ in range(t):
        if data_idx + 2 >= len(data):
            break
            
        n = int(data[data_idx])
        a = int(data[data_idx + 1])
        b = int(data[data_idx + 2])
        data_idx += 3

        # Logic translation
        
        if n < a:
            results.append("No")
            continue
        
        if a == b:
            if n % a == 0:
                results.append("Yes")
            else:
                results.append("No")
            continue
        
        # Case a != b
        
        # x = b / (b - a)
        # Since a, b are longs in Java, we use integer division // in Python
        x = b // (b - a)
        
        if n > x * a:
            results.append("Yes")
            continue
        
        # Binary search for ans: smallest k such that k*a >= n
        low = 1
        high = x + 1
        ans = 1
        
        while low <= high:
            mid = (low + high) // 2
            if mid * a < n:
                low = mid + 1
            else:
                ans = mid
                high = mid - 1
        
        # Final check
        # if (n > (ans - 1) * b and n < ans * a)
        if n > (ans - 1) * b and n < ans * a:
            results.append("No")