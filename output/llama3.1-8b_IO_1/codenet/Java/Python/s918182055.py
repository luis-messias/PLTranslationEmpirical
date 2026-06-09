import heapq
from collections import defaultdict, deque

class MyScanner:
    def __init__(self, in_stream):
        self.in_stream = in_stream

    def next(self):
        c = self.in_stream.read(1)
        while ord(c) <= 32 or (ord(c) == 13 and ord(c) == 10):
            c = self.in_stream.read(1)
        return c.decode('utf-8')

    def next_int(self):
        c = self.next()
        sign = 1
        if c == '-':
            sign = -1
            c = self.next()
        result = 0
        while ord(c) >= 48 and ord(c) <= 57:
            result = result * 10 + (ord(c) - 48)
            c = self.in_stream.read(1)
        return sign * result

    def next_long(self):
        c = self.next()
        sign = 1
        if c == '-':
            sign = -1
            c = self.next()
        result = 0
        while ord(c) >= 48 and ord(c) <= 57:
            result = result * 10 + (ord(c) - 48)
            c = self.in_stream.read(1)
        return sign * result

class MyWriter:
    def __init__(self, out_stream):
        self.out_stream = out_stream

    def print(self, obj):
        self.out_stream.write(str(obj))

    def println(self, obj):
        self.print(obj)
        self.out_stream.write('\n')

def main():
    N = int(input().split()[0])
    M = int(input().split()[0])

    graph = defaultdict(list)

    for _ in range(N):
        a = int(input().split()[0])
        b = int(input().split()[0])
        if not graph[a]:
            graph[a] = []
        graph[a].append(b)

    res = 0
    pq = []
    for i in range(1, M + 1):
        if graph[i]:
            heapq.heappush(pq, (-sum(graph[i]), i))
        while pq:
            _, node = heapq.heappop(pq)
            res += -graph[node].pop()

    print(res)

if __name__ == "__main__":
    main()
