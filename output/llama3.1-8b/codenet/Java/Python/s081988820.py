import sys
from typing import List, Set, Tuple
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


class PrimeNumberUtils:
    def __init__(self, limit: int):
        self.primes = []
        self.is_prime_array = [True] * (limit + 1)
        if limit > 2:
            self.primes.append(2)
            self.is_prime_array[2] = True

        for i in range(3, limit + 1, 2):
            if self.is_prime(i, self.primes):
                self.primes.append(i)
                self.is_prime_array[i] = True

    def is_prime(self, n: int) -> bool:
        return self.is_prime_array[n]

    def get_prime_number_list(self) -> List[int]:
        return self.primes


class LongBit(BitSet):
    def __init__(self, size: int):
        super().__init__(size)

    def or_(self, bitset: 'BitSet'):
        if isinstance(bitset, LongBit):
            for segment in range(len(self.bit_array)):
                self.bit_array[segment] |= bitset.get_long(segment)


def is_prime(n: int, primes: List[int]) -> bool:
    for prime in primes:
        if n % prime == 0:
            return False
        if prime > n ** 0.5:
            break
    return True


class UnionFindArray(UnionFind):
    def __init__(self, size: int):
        super().__init__(size)
        self.map = defaultdict(set)

    def union_to(self, source: int, dest: int):
        super().union(source, dest)
        self.map[dest].update(self.map[source])

    def get_set(self, id: int) -> Set[int]:
        return self.map[self.find(id)]


class ArrayUnionFind(UnionFind):
    def __init__(self, size: int):
        super().__init__(size)

    def union_to(self, source: int, dest: int):
        super().union(source, dest)


def main():
    # Example usage
    uf = UnionFindArray(10)
    uf.union(0, 1)
    print(uf.get_set(0))  # Output: {0, 1}

if __name__ == "__main__":
    main()