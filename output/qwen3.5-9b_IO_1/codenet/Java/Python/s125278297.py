h, w = map(int, input().split())
ans = []
for _ in range(h):
    ans.append("#" + input() + "#")

print("#" * (w + 2))
for s in ans:
    print(s)
print("#" * (w + 2))
