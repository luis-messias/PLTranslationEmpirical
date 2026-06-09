def generate_string():
    return ''.join(str(i) for i in range(1, 1001))

n = int(input())
s = generate_string()
print(s[n - 1])