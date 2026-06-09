def is_even_string(s):
    a = s[:len(s)//2]
    b = s[len(s)//2:]
    return True if a == b else False

s = input()
if len(s) % 2 != 0:
    s = s[:-1]

while len(s) > 0 and not is_even_string(s):
    s = s[:-2]

print(len(s))