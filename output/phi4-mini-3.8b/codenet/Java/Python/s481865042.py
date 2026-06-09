s = input()
k = int(input())
sb = [c for c in s]
for i, char in enumerate(s):
    if (ord(char) - ord('a') + 26 <= k and char != 'a'):
        k -= (ord(char) - ord('a'))
        sb[i] = 'a'
    else:
        pass
if k > 0:
    index = s.rfind(next((c for c in set(s if not c.isspace())), default=-1)
    last_char = list(set([s[-1]))
    first, second = (ord(last) - ord('a') + 26), (k % 2
sb[index] = chr(ord(first))
print("".join(sb))