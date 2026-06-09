import sys

def solve():
    # Read K from standard input
    try:
        # Read the first line and convert it to integer
        line = sys.stdin.readline()
        if not line:
            return
        K = int(line.strip())
    except EOFError:
        return
    except ValueError:
        # Handle case where input might not be a valid integer, though unlikely based on problem context
        return

    # Logic from solve()
    if K % 2 == 0 or K % 5 == 0:
        print(-1)
        return

    if K % 7 == 0:
        K //= 7
    
    K *= 9
    
    ans = 1
    # remainder = 10 % K
    remainder = 10 % K
    
    # while ( remainder != 1 ) { ans ++ ; remainder = remainder * 10 % K ; }
    while remainder != 1:
        ans += 1
        remainder = (remainder * 10) % K
        
    print(ans)

if __name__ == "__main__":
    solve()
