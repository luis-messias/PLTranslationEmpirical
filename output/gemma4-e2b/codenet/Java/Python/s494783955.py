import sys

try:
    # Read the input string
    C = sys.stdin.read().strip()
    
    if C:
        # Get the first character, calculate its ASCII value + 1, and convert back to a character
        first_char = C[0]
        result = chr(ord(first_char) + 1)
        print(result)
except:
    # Handle case where input might be empty or reading fails
    pass