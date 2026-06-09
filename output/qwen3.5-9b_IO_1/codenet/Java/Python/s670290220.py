N = int(input())
s = input()
result = ''.join(chr((ord(c) - ord('A') + N) % 26 + ord('A')) for c in s)
print(result)
