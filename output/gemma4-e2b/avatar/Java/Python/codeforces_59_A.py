import sys

word = sys.stdin.read().strip()

uppercase = 0
lowercase = 0

for char in word:
    if char.isupper():
        uppercase += 1
    else:
        lowercase += 1

if uppercase > lowercase:
    print(word.upper())
elif lowercase > uppercase:
    print(word.lower())
else:
    print(word.lower())