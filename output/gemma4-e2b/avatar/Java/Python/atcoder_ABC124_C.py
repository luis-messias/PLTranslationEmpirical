import sys

def solve():
    # Read the single line of input, which is the string x
    try:
        x = sys.stdin.readline().strip()
    except EOFError:
        return
    
    if not x:
        return

    L = len(x)
    
    # Initialize mutable lists for string manipulation
    a = list(x)
    b = list(x)
    a1 = 0
    a2 = 0

    # Logic for string a (forward pass)
    # Java loop: for ( int i = 1 ; i < x.length ( ) ; i ++ )
    for i in range(1, L):
        if a[i] == a[i - 1]:
            # Flip a[i]
            if a[i] == '1':
                a[i] = '0'
            else:
                a[i] = '1'
            a1 += 1

    # Logic for string b (backward pass)
    # Java loop: for ( int i = x.length ( ) - 1 ; i > 0 ; i -- )
    for i in range(L - 1, 0, -1):
        if b[i] == b[i - 1]:
            # Flip b[i-1]
            if b[i - 1] == '1':
                b[i - 1] = '0'
            else:
                b[i - 1] = '1'
            a2 += 1

    # Output the result
    print(min(a1, a2))

if __name__ == "__main__":
    solve()