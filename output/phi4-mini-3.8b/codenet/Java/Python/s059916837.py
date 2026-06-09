def find(a, b):
    calc = 0
    for x in range(len(a)):
        if a[x] != b[x]:
            calc += 1
    return calc

S = input()
T = input()

min_diff = float('inf')

for i in range(len(S) - len(T) + 1):
    substring = S[i:i+len(T)]
    min_diff = min(min_diff, find(substring, T))

if min_diff != float('inf'):
    print(min_diff)
else:
    print(len(T))