import sys

word = sys.stdin.read().strip()
uppercase = 0
lowercase = 0
for ch in word:
    if ch.isupper():
        uppercase += 1
    elif ch.islower():
        lowercase += 1

if uppercase > lowercase:
    print(word.upper())
else:
    print(word.lower())
