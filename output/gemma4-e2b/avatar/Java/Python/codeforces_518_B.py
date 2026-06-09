import sys

def reverse(ch):
    if 'a' <= ch <= 'z':
        return ch.upper()
    else:
        return ch.lower()

def solve():
    # Read input from stdin. Assuming two tokens are provided.
    try:
        # Read the first string (s)
        s = sys.stdin.readline().strip()
        # Read the second string (t)
        t = sys.stdin.readline().strip()
    except EOFError:
        return

    if not s or not t:
        return

    # Step 1: Calculate character frequencies in t (tmap)
    tmap = {}
    for char in t:
        tmap[char] = tmap.get(char, 0) + 1

    length = len(s)
    ura = 0
    opa = 0

    # Step 2: Modify s and calculate ura
    # Note: The Java code uses s.setCharAt(i, 'Я'). We use 'Я' directly.
    for i in range(length):
        ch = s[i]
        num = tmap.get(ch, 0)
        
        if num == 0:
            continue
            
        inum = num
        if inum == 1:
            if ch in tmap:
                del tmap[ch]
        else:
            tmap[ch] = inum - 1
            
        s = list(s) # Convert to list for mutable character replacement
        s[i] = 'Я'
        ura += 1

    # Step 3: Calculate opa
    # We need to re-evaluate the map state based on the modifications in Step 2.
    # The Java code iterates over the modified s and uses the *remaining* counts in tmap.
    
    # Re-initialize tmap for the second pass, as the first pass modified it.
    # Wait, the Java code uses the modified tmap from the first loop for the second loop.
    # Let's stick to the structure: tmap is modified in place.

    # The Java code iterates over the *modified* s and uses the *modified* tmap.
    # The modification in Step 2 was:
    # if inum == 1 tmap.remove(ch) else tmap.put(ch, inum - 1)
    
    # Now, calculate opa based on the modified s and the modified tmap.
    for i in range(length):
        ch = s[i]
        rch = reverse(ch)
        
        num = tmap.get(rch, 0)
        
        if num == 0:
            continue
            
        inum = num
        if inum == 1:
            if rch in tmap:
                del tmap[rch]
        else:
            tmap[rch] = inum - 1
            
        opa += 1

    print(f"{ura} {opa}")

solve()