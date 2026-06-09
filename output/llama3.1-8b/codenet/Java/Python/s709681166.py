import re

s = input()
print(re.sub(r'[A-Z]', lambda x: chr(ord(x.group()) - 32), re.sub(r'[a-z]', lambda x: chr(ord(x.group()) + 32), s)))