import sys

def solve():
    # Reading inputs sequentially, mimicking sc.nextInt()
    try:
        # Read all lines/inputs and convert to integers
        input_data = sys.stdin.read().split()
        if len(input_data) < 4:
            # Handle case where input might be missing
            return
        
        a = int(input_data[0])
        b = int(input_data[1])
        c = int(input_data[2])
        x = int(input_data[3])
    except Exception:
        # Fallback if input reading fails
        return

    res = 0

    for i in range(a + 1):
        for j in range(b + 1):
            for k in range(c + 1):
                total = 500 * i + 100 * j + 50 * k
                
                if total == x:
                    res += 1
    
    # The print statement must execute only once, after all loops complete, 
    # to match the expected output structure.
    print(res)

solve()
