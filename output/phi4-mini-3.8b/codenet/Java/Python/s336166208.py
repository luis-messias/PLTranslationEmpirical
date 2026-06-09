info = [[[0 for _ in range(10)] for _ in range(3)] for _ in range(4)]

built, floor, room, num = map(int, input().split())
info[built - 1][floor - 1][room - 1] += num

for i in info:
    print(' '.join(map(str, i)))