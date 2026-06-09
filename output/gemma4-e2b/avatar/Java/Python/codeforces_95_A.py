import sys

def compare(aa, i, bb, j, m):
    """
    Compares two character arrays (strings) case-insensitively.
    Returns 0 if they match, or the difference in ASCII values if they differ.
    """
    diff = 0
    for k in range(m):
        a = ord(aa[i + k].upper())
        b = ord(bb[j + k].upper())
        if a != b:
            return a - b
    return 0

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # Input parsing based on the Java structure
    
    # n = sc.nextInt()
    n = int(data[0])
    
    # ss = new char[n][]. Read n strings.
    ss = []
    data_idx = 1
    for _ in range(n):
        ss.append(data[data_idx])
        data_idx += 1
        
    # cc = sc.next().toCharArray()
    cc = data[data_idx]
    data_idx += 1
    
    # c = sc.next().charAt(0)
    c = data[data_idx]
    data_idx += 1
    
    # Setup variables based on Java logic
    m = len(cc)
    
    # c_ = Character.toUpperCase(c)
    c_ = c.upper()
    
    # a = c == 'a' ? 'b' : 'a'
    if c == 'a':
        a = 'b'
    else:
        a = 'a'
        
    # a_ = Character.toUpperCase(a)
    a_ = a.upper()
    
    # lucky = new boolean[m]
    lucky = [False] * m
    
    # Main loop for finding matches
    for j in range(m):
        for i in range(n):
            l = len(ss[i])
            
            # if ( m - j >= l && compare(cc, j, ss[i], 0, l) == 0 )
            if m - j >= l:
                if compare(cc, j, ss[i], 0, l) == 0:
                    # for ( int h = 0 ; h < l ; h ++ ) lucky[j + h] = true;
                    for h in range(l):
                        lucky[j + h] = True

    # Final modification of cc
    for j in range(m):
        if lucky[j]:
            # if ( Character.toLowerCase(cc[j]) == c )
            if cc[j].lower() == c:
                # cc[j