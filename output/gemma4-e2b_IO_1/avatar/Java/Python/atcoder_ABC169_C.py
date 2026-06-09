import sys

try:
    # Read all space-separated inputs
    data = sys.stdin.read().split()
    if len(data) >= 2:
        a = int(data[0])
        b = data[1]
    else:
        # Handle case where input is insufficient
        sys.exit()
except Exception:
    # Exit if input reading fails
    sys.exit()

# Process b to extract digits, ignoring '.'
b_str = ""
for char in b:
    if char != '.':
        b_str += char

# Convert the extracted string to an integer
if b_str:
    b_int = int(b_str)
else:
    b_int = 0

# Calculate the result using integer division
# Java: long result = (a * bInt) / 100;
result = (a * b_int) // 100

print(result)
