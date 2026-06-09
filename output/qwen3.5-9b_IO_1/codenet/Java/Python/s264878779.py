s = input()
n = len(s)
ans = 0
for mask in range(1 << (n - 1)):
    x = s[0]
    for i in range(n - 1):
        if (mask & (1 << i)):
            x += "+" + s[i + 1]
        else:
            x += s[i + 1]
    parts = x.split("+")
    sum_val = sum(int(part) for part in parts)
    ans += sum_val
print(ans)
