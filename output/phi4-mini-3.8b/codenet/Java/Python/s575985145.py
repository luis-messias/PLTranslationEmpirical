import sys

size = int(input())
graph = [0] * size

for i in range(size):
    id, cols = map(int, input().split())
    row = list(map(lambda x: 1 if (x - 1) < len(graph[i]) else 0, 
                   map(int, input().split()))
    graph[id - 1] = [int(x) for x in range(cols)]

for i in graph:
    print(" ".join(str(x) for x in i))