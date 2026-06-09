import sys

a = int(input())
b = input()
b_list = list(b)
length = len(b_list)

b_str = ''.join([char for char in b_list if char != '.'])
b_int = int(''.join([char for char in b_list if char.isdigit() or char == '.']))
result = (a * b_int) // 100
print(result)
