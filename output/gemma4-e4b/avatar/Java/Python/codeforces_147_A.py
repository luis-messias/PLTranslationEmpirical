import sys

def is_latin_letter(c):
    """Checks if a character is a lowercase English letter ('a' through 'z')."""
    return 'a' <= c <= 'z'

def is_punctuation(c):
    """Checks if a character is one of the specified punctuation marks."""
    return c in ['.', ',', '!', '?']

def solve():
    # Read the entire line from standard input
    try:
        s = sys.stdin.read().strip()
    except:
        s = ""

    if not s:
        print("")
        return

    result = []
    n = len(s)

    # The Java code initializes the StringBuilder with the first character
    result.append(s[0])

    for i in range(1, n):
        c = s[i]
        
        if is_latin_letter(c):
            prev_c = s[i-1]
            
            # If the previous character was NOT a letter, prepend a space
            if not is_latin_letter(prev_c):
                result.append(' ')
            
            result.append(c)
        
        elif is_punctuation(c):
            # If it is punctuation, just append it
            result.append(c)
        
        # Characters that are neither letters nor specified punctuation are ignored, 
        # matching the behavior of the original Java code.

    print("".join(result))

if __name__ == "__main__":
    solve()