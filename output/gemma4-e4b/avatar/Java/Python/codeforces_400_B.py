import sys

def solve():
    # Read all tokens from standard input
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the count of strings, M is the second integer (unused in logic)
    n = int(data[0])
    # m = int(data[1]) # m is read but not used
    
    # The strings start from index 2 up to n+1
    arrs = data[2:n+2]

    length = []
    return_dex = 0

    for tmp in arrs:
        # str.find() returns -1 if the substring is not found, matching Java's indexOf behavior.
        dex_g = tmp.find("G")
        dex_s = tmp.find("S")
        
        if dex_g > dex_s:
            return_dex = -1
        
        # Calculate length: dexS - dexG
        length.append(dex_s - dex_g)

    # Create the set of unique lengths
    s = set(length)

    # Output based on the condition
    if return_dex == -1:
        print(return_dex)
    else:
        print(len(s))

if __name__ == "__main__":
    solve()