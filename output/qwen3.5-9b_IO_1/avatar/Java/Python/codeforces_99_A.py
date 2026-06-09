import sys

s = sys.stdin.readline().strip()
dot_index = s.find('.')

if s[dot_index - 1] == '9':
    print("GOTO Vasilisa.")
elif int(s[dot_index + 1]) > 4:
    integer_part = int(s[:dot_index])
    print(integer_part + 1)
else:
    print(s[:dot_index])
