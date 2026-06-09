import sys

def solve():
    # Read input from stdin, assuming space-separated integers
    try:
        data = sys.stdin.read().split()
        if len(data) < 2:
            return
        
        n = int(data[0])
        k = int(data[1])
        
        # Java logic: n++
        n += 1
        
        z = 0
        
        # if (n % k != 0) z = k - n % k
        remainder = n % k
        if remainder != 0:
            z = k - remainder
            
        # System.out.println (n + z)
        print(n + z)
        
    except Exception:
        # Handle potential errors during input reading/conversion
        pass

solve()
