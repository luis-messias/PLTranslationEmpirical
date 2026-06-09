n = int(input())
str_list = input().split(" ")

s = [0] * 100010

for i in range(n):
    s[int(str_list[i])] += 1

dec = 0

for x in s:
    if x != 0 and (x % 2 == 0 or x % 3 == 0) and not is_prime(x // 10 + 5 * (x - dec)):
        continue
    else:
        dec += 1

print(dec)