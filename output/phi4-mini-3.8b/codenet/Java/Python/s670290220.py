import sys

n = int(sys.stdin.readline().strip())
s = input()
for i in range(len(s)):
    s = list(s)
    for j in range(26):
        if (ord(s[i]) - 65 + n) % 26 == ord('A'):
            print(chr((ord(s[i] - 1 + 2 * (j)) % 25 + 1))