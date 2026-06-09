s = input()
for i in range(len(s)):
    if 'A' <= s[i] and s[i] <= 'Z':
        print(chr((ord(s[i]) - 65 + 32) % 26 + 65), end='')
    elif 'a' <= s[i] and s[i] <= 'z':
        print(chr((ord(s[i]) - 97 + 1) % 26 + 97)