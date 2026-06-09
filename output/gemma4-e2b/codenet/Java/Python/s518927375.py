import sys

def main():
    # Read k, a, b from standard input
    try:
        # Read all inputs from stdin, assuming they are provided sequentially
        data = sys.stdin.read().split()
        if len(data) < 3:
            return
        
        k = int(data[0])
        a = int(data[1])
        b = int(data[2])
    except:
        # Handle potential reading errors
        return

    if b <= a + 2:
        print(1 + k)
        return

    # long x = k - (a - 1);
    x = k - (a - 1)
    
    # long ans = a + (x / 2) * (b - a) + (x % 2);
    # Use // for integer division (equivalent to Java's integer division for longs)
    ans = a + (x // 2) * (b - a) + (x % 2)

    print(ans)

if __name__ == "__main__":
    main()