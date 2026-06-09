import sys

c = sys.stdin.read().strip()

if c:
    # Get the first character
    first_char = c[0]
    
    # Get its ASCII value, increment it, and convert back to a character
    new_char_code = ord(first_char) + 1
    result_char = chr(new_char_code)
    
    print(result_char)