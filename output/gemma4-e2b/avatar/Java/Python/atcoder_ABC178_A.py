import sys

try:
    # Read the single integer input
    x = int(sys.stdin.read().strip())
except:
    # Handle case where input might be missing or invalid
    sys.exit()

# Java logic translation:
# bool = x == 1
# result = !bool ? 1 : 0
# If x == 1, bool is True, result is 0.
# If x != 1, bool is False, result is 1.

if x == 1:
    result = 0
else:
    result = 1

print(result)