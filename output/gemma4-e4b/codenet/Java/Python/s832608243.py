import math
import sys

def main():
    # Read a and b from standard input
    try:
        # Read all input and split it into two integers
        data = sys.stdin.read().split()
        if len(data) < 2:
            return
        a = int(data[0])
        b = int(data[1])
    except Exception:
        # Handle case where input might be missing or malformed
        return

    flag = False
    
    # Loop from i=1 to i=100000
    for i in range(1, 100001):
        # Calculate Math.floor(1.* i *.08)
        val_a = math.floor(i * 0.08)
        
        # Calculate Math.floor(.1 * i)
        val_b = math.floor(i * 0.1)
        
        if val_a == a and b == val_b:
            print(i)
            flag = True
            break
            
    if not flag:
        print(-1)

if __name__ == "__main__":
    main()