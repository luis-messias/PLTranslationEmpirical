import sys

def solve():
    # Read all tokens from standard input
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        s = data[0]
        k = int(data[1])
    except Exception:
        # Handle case where input might be missing or malformed
        return

    sb = []

    for char in s:
        # Calculate the cost to change char to 'a'
        # Index of char: ord(char) - ord('a')
        
        if char == 'a':
            cost = 0
        else:
            index = ord(char) - ord('a')
            cost = 26 - index
        
        # Check condition:
        if cost <= k and char != 'a':
            k -= cost
            sb.append('a')
        else:
            sb.append(char)
    
    # Post-processing step (if k > 0)
    if k > 0:
        if sb:
            # Get the last character
            t = sb[-1]
            
            # Delete the last character
            sb.pop()
            
            # Calculate the new character: 'a' + (t - 'a' + k) % 26
            t_index = ord(t) - ord('a')
            new_index = (t_index + k) % 26
            new_char = chr(ord('a') + new_index)
            
            sb.append(new_char)
    
    print("".join(sb))

solve()
