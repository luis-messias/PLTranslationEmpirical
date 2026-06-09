def solve():
    import sys
    # Read the entire line of input
    try:
        s = sys.stdin.readline().strip()
    except:
        s = ""

    ch = None
    length = len(s)
    
    # Iterate backwards to find the last character that is not ' ' or '?'
    for i in range(length - 1, -1, -1):
        char = s[i]
        if char != ' ' and char != '?':
            ch = char
            break
    
    # If no character was found, ch remains None, which should result in "NO".
    if ch is None:
        print("NO")
        return

    # Convert to lowercase
    ch_lower = ch.lower()
    
    # Check for vowels (a, e, i, o, u, y)
    vowels = {'a', 'e', 'i', 'o', 'u', 'y'}
    
    if ch_lower in vowels:
        print("YES")
    else:
        print("NO")

solve()