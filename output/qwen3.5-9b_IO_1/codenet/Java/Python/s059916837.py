def find(a, b):
    calc = 0
    for x in range(len(a)):
        if a[x] != b[x]:
            calc += 1
    return calc

S = input()
T = input()
min_dist = float('inf')
for i in range(len(S) - len(T) + 1):
    min_dist = min(min_dist, find(S[i:i+len(T)], T))
if min_dist != float('inf'):
    print(min_dist)
else:
    print(len(T))
