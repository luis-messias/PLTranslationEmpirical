import sys

try:
    r = int(sys.stdin.read().strip())
    print(3 * r * r)
except:
    # Handle case where input might be empty or invalid, though typically not strictly necessary for this type of translation request.
    pass