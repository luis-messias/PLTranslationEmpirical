import sys

# Read all input tokens
data = sys.stdin.read().split()

if len(data) < 2:
    # Handle insufficient input
    exit()

N = int(data[0])
S = data[1]

result = []
base = ord('A')

for char in S:
    # Apply the Caesar cipher shift logic: (char - 'A' + N) % 26 + 'A'
    
    # Calculate the 0-indexed position of the character
    current_pos = ord(char) - base
    
    # Apply the shift and wrap around
    new_pos = (current_pos + N) % 26
    
    # Convert back to the shifted character
    new_char = chr(new_pos + base)
    result.append(new_char)

print("".join(result))
