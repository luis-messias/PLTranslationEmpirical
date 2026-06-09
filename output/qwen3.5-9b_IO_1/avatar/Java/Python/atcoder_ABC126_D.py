import sys
from collections import defaultdict

class Point:
    def __init__(self, name):
        self.name = name
        self.friends = {}
    
    def become_friend(self, p, length):
        self.friends[p] = length

def dfs(p, length, colors):
    if colors[p.name] != -1:
        return
    if length % 2 == 0:
        colors[p.name] = 0
    else:
        colors[p.name] = 1
    for friend, length2 in p.friends.items():
        dfs(friend, length + length2, colors)

def main():
    n = int(input())
    m = n - 1
    colors = [-1] * n
    points = [Point(i) for i in range(n)]
    
    for _ in range(m):
        me, you, length = map(int, input().split())
        me -= 1
        you -= 1
        points[me].become_friend(points[you], length)
        points[you].become_friend(points[me], length)
    
    dfs(points[0], 0, colors)
    
    for c in colors:
        print(c)

if __name__ == "__main__":
    main()
