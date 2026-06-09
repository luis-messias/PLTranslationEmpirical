s = input()
result = ""
for c in s:
    if c.isupper():
        result += c.lower()
    elif c.islower():
        result += c.upper()
    else:
        result += c
print(result)
