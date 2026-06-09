import sys

def solve():
    # Read all tokens from standard input
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        
        a = int(data[0])
        b = data[1]
    except Exception:
        # Handle potential input errors
        return

    # Filter out dots from string b
    b_str = b.replace('.', '')
    
    # Convert the resulting string to an integer
    if not b_str:
        b_int = 0
    else:
        b_int = int(b_str)
        
    # Calculate (a * b_int) / 100 using integer division
    result = (a * b_int) // 100
    
    print(result)

solve()