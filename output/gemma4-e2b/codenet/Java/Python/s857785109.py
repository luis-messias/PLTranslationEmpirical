import sys

try:
    # Read the integer n from standard input
    n = int(sys.stdin.read().strip())
except:
    # Handle case where input might be missing or invalid
    sys.exit()

# Check the conditions
# Condition 1: (n / 10) % 111 == 0
# In Python, we use integer division //
condition1 = (n // 10) % 111 == 0

# Condition 2: (n % 1000) % 111 == 0
condition2 = (n % 1000) % 111 == 0

if condition1 or condition2:
    print("Yes")
else:
    print("No")