n = int(input())
input()  # consume the newline after reading n
unique_strings = set()
for _ in range(n):
    unique_strings.add(input())
print(len(unique_strings))
