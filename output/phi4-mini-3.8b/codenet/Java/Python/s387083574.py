N = int(input())
map_dict = {}
for i in range(1, N + 1):
    map_dict[i] = int(input())

sorted_keys = sorted(map_dict.keys(), key=lambda x: (map_dict[x], -x))
print(" ".join(str(key) for key in sorted_keys))