from typing import List, Set, Dict
from collections import defaultdict
import sys

class UnionFind:
    def __init__(self, size: int):
        self.parent = list(range(size))
        self.rank = [0] * size
        self.size = size
    
    def root(self, id: int) -> int:
        if self.parent[id] == id:
            return id
        self.parent[id] = self.root(self.parent[id])
        return self.parent[id]
    
    def union(self, A: int, B: int) -> None:
        rootA = self.root(A)
        rootB = self.root(B)
        if rootA != rootB:
            if self.rank[rootA] < self.rank[rootB]:
                self.parent[rootA] = rootB
            else:
                self.parent[rootB] = rootA
                if self.rank[rootA] == self.rank[rootB]:
                    self.rank[rootA] += 1
    
    def judge(self, A: int, B: int) -> bool:
        return self.root(A) == self.root(B)
    
    def getSet(self, id: int) -> Set[int]:
        return {i for i in range(self.size) if self.judge(i, id)}

class MapUnionFind(UnionFind):
    def __init__(self, size: int):
        super().__init__(size)
        self.map = defaultdict(set)
        for i in range(size):
            self.map[i].add(i)
    
    def unionTo(self, source: int, dest: int) -> None:
        self.map[dest].update(self.map[source])
        self.map[source].clear()
    
    def getSet(self, id: int) -> Set[int]:
        return self.map[self.root(id)]

class ArrayUnionFind(UnionFind):
    def unionTo(self, source: int, dest: int) -> None:
        self.parent[source] = dest
    
    def getSet(self, id: int) -> Set[int]:
        set_result = set()
        for i in range(self.size):
            if self.judge(i, id):
                set_result.add(i)
        return set_result

class PrimeNumberUtils:
    def __init__(self, limit: int):
        self.isPrimeArray = [True] * limit
        self.primes = []
        if limit > 2:
            self.primes.append(2)
            self.isPrimeArray[2] = True
        for i in range(3, limit, 2):
            if self.isPrime(i, self.primes):
                self.primes.append(i)
                self.isPrimeArray[i] = True
    
    def isPrime(self, n: int) -> bool:
        return self.isPrimeArray[n]
    
    def getPrimeNumberList(self) -> List[int]:
        return self.primes
    
    def isPrime(self, n: int, primes: List[int]) -> bool:
        for prime in primes:
            if n % prime == 0:
                return False
            if prime > n ** 0.5:
                break
        return True

class BitSet:
    pass

class LongBit(BitSet):
    def __init__(self, size: int):
        self.bitArray = [0] * ((size + 63) // 64)
    
    def set(self, index: int, bit: bool) -> None:
        segment = index // 64
        inIndex = index % 64
        if bit:
            self.bitArray[segment] |= 1 << inIndex
        else:
            self.bitArray[segment] &= ~(1 << inIndex)
    
    def get(self, index: int) -> bool:
        segment = index // 64
        inIndex = index % 64
        return bool(self.bitArray[segment] & (1 << inIndex))
    
    def shiftRight(self, num: int) -> None:
        shiftSeg = num // 64
        shiftInI = num % 64
        for segment in range(len(self.bitArray)):
            sourceSeg = segment + shiftSeg
            if sourceSeg < len(self.bitArray):
                self.bitArray[segment] = self.bitArray[sourceSeg] >> shiftInI
                if shiftInI > 0 and sourceSeg + 1 < len(self.bitArray):
                    self.bitArray[segment] |= self.bitArray[sourceSeg + 1] << (64 - shiftInI)
            else:
                self.bitArray[segment] = 0
    
    def shiftLeft(self, num: int) -> None:
        shiftSeg = num // 64
        shiftInI = num % 64
        for segment in range(len(self.bitArray) - 1, -1, -1):
            sourceSeg = segment - shiftSeg
            if sourceSeg >= 0:
                self.bitArray[segment] = self.bitArray[sourceSeg] << shiftInI
                if shiftInI > 0 and sourceSeg > 0:
                    self.bitArray[segment] |= self.bitArray[sourceSeg - 1] >> (64 - shiftInI)
            else:
                self.bitArray[segment] = 0
    
    def or(self, bitset: BitSet) -> None:
        if isinstance(bitset, LongBit):
            for segment in range(len(self.bitArray)):
                self.bitArray[segment] |= bitset.bitArray[segment]
    
    def and(self, bitset: BitSet) -> None:
        if isinstance(bitset, LongBit):
            for segment in range(len(self.bitArray)):
                self.bitArray[segment] &= bitset.bitArray[segment]

def solve() -> int:
    input_data = sys.stdin.read().split()
    if not input_data:
        return 0
    
    iterator = iter(input_data)
    
    try:
        n = int(next(iterator))
        m = int(next(iterator))
    except StopIteration:
        return 0
    
    grid = []
    for _ in range(n):
        row = []
        for _ in range(m):
            row.append(int(next(iterator)))
        grid.append(row)
    
    try:
        for _ in range(4):
            next(iterator)
    except StopIteration:
        pass
    
    try:
        q = int(next(iterator))
        for _ in range(q):
            next(iterator)
            next(iterator)
            next(iterator)
            next(iterator)
    except StopIteration:
        pass
    
    uf = UnionFind(n * m)
    
    for i in range(n):
