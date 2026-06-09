from collections import defaultdict

class UnionFind:
    def __init__(self, size):
        self.parent = list(range(size))
        self.rank = [0] * size

    def find(self, x: int) -> int:
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x: int, y: int):
        root_x = self.find(x)
        root_y = self.find(y)
        if root_x != root_y:
            if self.rank[root_x] < self.rank[root_y]:
                self.parent[root_x] = root_y
            else:
                self.parent[root_y] = root_x
                if self.rank[root_x] == self.rank[root_y]:
                    self.rank[root_x] += 1

class BitSet:
    def __init__(self, size):
        self.bit_array = [0] * ((size + 63) // 64)

    def set(self, index: int, bit: bool):
        segment = index // 64
        in_index = index % 64
        if bit:
            self.bit_array[segment] |= 1 << in_index
        else:
            self.bit_array[segment] &= ~(1 << in_index)

    def get(self, index: int) -> bool:
        segment = index // 64
        in_index = index % 64
        return (self.bit_array[segment] & (1 << in_index)) != 0

    def shift_right(self, num: int):
        shift_seg = num // 64
        shift_in_i = num % 64
        for segment in range(len(self.bit_array)):
            source_seg = segment + shift_seg
            if source_seg < len(self.bit_array):
                self.bit_array[segment] = self.bit_array[source_seg] >> shift_in_i
                if shift_in_i > 0 and source_seg + 1 < len(self.bit_array):
                    self.bit_array[segment] |= self.bit_array[source_seg + 1] << (64 - shift_in_i)
            else:
                self.bit_array[segment] = 0

    def shift_left(self, num: int):
        shift_seg = num // 64
        shift_in_i = num % 64
        for segment in range(len(self.bit_array) - 1, -1, -1):
            source_seg = segment - shift_seg
            if source_seg >= 0:
                self.bit_array[segment] = self.bit_array[source_seg] << shift_in_i
                if shift_in_i > 0 and source_seg > 0:
                    self.bit_array[segment] |= self.bit_array[source_seg - 1] >> (64 - shift_in_i)
            else:
                self.bit_array[segment] = 0

    def or_(self, bitset: 'BitSet'):
        if isinstance(bitset, LongBit):
            for segment in range(len(self.bit_array)):
                self.bit_array[segment] |= bitset.get_long(segment)

    def and_(self, bitset: 'BitSet'):
        if isinstance(bitset, LongBit):
            for segment in range(len(self.bit_array)):
                self.bit_array[segment] &= bitset.get_long(segment)


class UnionFindArray(UnionFind):
    def __init__(self, size):
        super().__init__(size)
        self.map = defaultdict(set)

    def union_to(self, source: int, dest: int):
        super().union(source, dest)
        self.map[dest].update(self.map[source])

    def get_set(self, id: int) -> set:
        return self.map[self.find(id)]


class LongBit(BitSet):
    def __init__(self, size):
        super().__init__(size)

    def or_(self, bitset: 'BitSet'):
        if isinstance(bitset, LongBit):
            for segment in range(len(self.bit_array)):
                self.bit_array[segment] |= bitset.get_long(segment)


def is_prime(n: int, primes: list) -> bool:
    for prime in primes:
        if n % prime == 0:
            return False
        if prime > n ** 0.5:
            break
    return True


class Graph:
    def __init__(self, num_vertices):
        self.num_vertices = num_vertices
        self.adj_list = [[] for _ in range(num_vertices)]

    def add_edge(self, u: int, v: int):
        self.adj_list[u].append(v)
        self.adj_list[v].append(u)

    def bfs(self, s: int) -> int:
        visited = [False] * self.num_vertices
        queue = []
        parent = [-1] * self.num_vertices

        visited[s] = True
        queue.append(s)

        while queue:
            u = queue.pop(0)
            for v in self.adj_list[u]:
                if not visited[v]:
                    visited[v] = True
                    parent[v] = u
                    queue.append(v)

        return parent


def main():
    num_vertices, _ = map(int, input().split())
    graph = Graph(num_vertices)
    edges = []
    for i in range(num_vertices):
        row = list(map(int, input().split()))
        for j in range(i + 1, num_vertices):
            if row[j] == 9:
                edges.append((i, j))
                graph.add_edge(i, j)

    parent = graph.bfs(0)
    uf = UnionFindArray(num_vertices)
    for edge in edges:
        u, v = edge
        uf.union_to(u, v)

    max_component_size = 0
    current_component_size = 1
    visited = [False] * num_vertices

    for i in range(num_vertices):
        if not visited[i]:
            current_component_size = 1
            j = parent[i]
            while j != -1:
                visited[j] = True
                current_component_size += 1
                j = parent[j]

            max_component_size = max(max_component_size, current_component_size)

    print(max_component_size)


if __name__ == "__main__":
    main()
