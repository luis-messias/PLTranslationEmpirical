import sys

try:
    # Read the integer from standard input
    n = int(sys.stdin.read().strip())
except:
    # Handle case where input might be empty or invalid, though usually not necessary for this type of translation
    # If running interactively, we might use input() instead.
    exit()

if n % 10 == 9 or n // 10 == 9:
    print("Yes")
else:
    print("No")