import sys

# Read input a (long)
try:
    a = int(sys.stdin.readline())
except:
    # Handle case where input might be empty or invalid if running interactively without proper input stream setup
    exit()

# Read input b (String)
b = sys.stdin.readline().strip()

# Process b to extract digits, ignoring '.'
b_str = ""
for char in b:
    if char != '.':
        b_str += char

# Convert the extracted string to an integer
if b_str:
    b_int = int(b_str)
else:
    # If no digits are found (e.g., input was only "."), treat as 0 for calculation safety
    b_int = 0

# Calculate the result using integer division
# Java: long result = (a * bInt) / 100;
result = (a * b_int) // 100

print(result)