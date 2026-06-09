import sys

def main():
    # Read input from stdin
    try:
        # Read the single integer n
        n = int(sys.stdin.read().strip())
    except:
        # Handle case where input might be missing or invalid
        return

    s = ""
    temp_n = n
    
    # Mimic the Java loop: extract bits and build the string s
    while temp_n > 0:
        x = temp_n % 2
        temp_n //= 2
        s += str(x)
        
    # Count the number of '1's in the string s
    ans = s.count('1')
    
    print(ans)

if __name__ == "__main__":
    main()