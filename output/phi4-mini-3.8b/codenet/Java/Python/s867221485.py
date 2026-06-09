import sys

N, K, Q, A, B, C = map(int, input().split())
ans, min = 0, 9999999


s = input()
flag, first = True, False
sha, dot, temp = 0, 0, 0

for i in range(N):
    if s[i] == '#':
        if not flag:
            ans += sha
        else:
            min = max(min, (i - A + 1) * Q)
        
        first = False
        
        if dot <= 2 and C > 3: 
            print(0)

        while i < N and s[i] == '#':
            i += 1

    if not flag:
        sha += 1
    else:
        min, temp, A, B = (i - A + 1) * Q, dot, first, False
        
if not flag: 
    ans += max(0, C)
    
print(ans + sum([min for i in range(N and s[i] == '#') if i < N]))