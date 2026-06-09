n, k = map(int, input().split())
k = int(input())

d_map = {}

for _ in range(k):
    d = list(map(int, input().split()))
    for i in range(1, len(d)):
        if not (i + 1) % 2:
            person = d[i - 1]
            while person and not map.get(person): 
                count += 1