from collections import defaultdict, deque

class Point:
    def __init__(self, name):
        self.name = name
        self.friends = defaultdict(int)

def dfs(p, length):
    if colors[p.name] != -1:
        return
    if length % 2 == 0:
        colors[p.name] = 0
    else:
        colors[p.name] = 1
    for friend, length2 in p.friends.items():
        dfs(friend, length + length2)

n = int(input())
m = n - 1

colors = [-1]*n

points = [Point(i) for i in range(n)]
for _ in range(m):
    me = int(input()) - 1
    you = int(input()) - 1
    length = int(input())
    points[me].becomeFriend(points[you], length)
    points[you].becomeFriend(points[me], length)

dfs(points[0], 0)
print(*colors)
