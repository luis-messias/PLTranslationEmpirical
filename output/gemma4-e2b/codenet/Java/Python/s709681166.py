import sys

s = sys.stdin.readline()

for c in s:
    if 'A' <= c <= 'Z':
        # Convert uppercase to lowercase
        print(chr(ord(c) + 32), end='')
    elif 'a' <= c <= 'z':
        # Convert lowercase to uppercase
        print(chr(ord(c) - 32), end='')
    else:
        # Print other characters as is
        print(c, end='')

# Print the final newline, matching System.out.println()
print()