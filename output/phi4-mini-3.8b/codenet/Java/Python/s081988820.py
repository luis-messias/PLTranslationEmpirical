class UnionFind:
    def __init__(self, size):
        self.parent = [i for i in range(size)]
        self.rank = [0] * size

    def find(self, x: int) -> int:
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x: int, y: int):
        rootx = self.find(x)
        rooty = self.find(y)

        if rootx == rooty:
            return

        if self.rank[rootx] < self.rank[rooty]:
            self.parent[rootx] = rooty
        elif self.rank[rootx] > self.rank[rooty]:
            self.parent[rooty] = rootx
        else:
            self.parent[rooty] = rootx
            self.rank[rootx] += 1

    def connected(self, x: int, y: int) -> bool:
        return self.find(x) == self.find(y)

class PrimeNumberUtils:
    @staticmethod
    def is_prime(n):
        if n < 2 or (n % 2 == 0 and n > 2): 
            return False

        for i in range(3, int(math.sqrt(n)) + 1, 2):
            if n % i == 0:
                return False
        return True


class BitSet:
    def __init__(self, size: int = None) -> None:
        self.size = (size or 64)
        self.bit_array = [0] * ((self.size + 63) // 64)

    @property
    def get(self, index):
        segment_index = index >> 6
        bit_position = index & 7

        return bool((self.bit_array[segment_index] >> (bit_position)) % 2 and self.bit_array[segment_index])

    def set(self, index: int) -> None:
        if not isinstance(index, int):
            raise TypeError("index must be an integer")
        
        segment = index // 64
        bit_pos = index & 7

        # Set the value at this position to true (1)
        self.bit_array[segment] |= 1 << bit_pos
    
    def clear(self) -> None:
        for i in range(len(self.bit_array)):
            self.bit_array[i] &= ~(1 << ((i * 64 + 63) % 64))

    @property
    def get_long(self, index: int):
        if not isinstance(index, int):
            raise TypeError("index must be an integer")

        segment = (self.size or 0)
        return self.bit_array[index // 64] & ((1 << (segment * 8 + index % 8)) - 1)

    def get_long(self) property:
        if not isinstance(index, int):
            raise TypeError("index must be an integer")

        segment = index
        result = [self.get(i) for i in range(segment)]
        
        return tuple(result)


class LongBit(BitSet):
    @property
    def long_get(self, index: int):
        # Return the value at this position as a 64-bit number.
        if not isinstance(index, int):
            raise TypeError("index must be an integer")

        segment = (self.size or 0)
        return self.bit_array[index // 64] & ((1 << (segment * 8 + index % 8)) - 1)

    def get_long(self) property:
        if not isinstance(index, int):
            raise TypeError("index must be an integer")

        segment = index
        result = [self.get(i) for i in range(segment)]
        
        return tuple(result)


# Example usage:

uf = UnionFind(10)
print(uf.connected(1, 2)) # False

PrimeNumberUtils.is_prime(7) # True
bitset = BitSet()
bitset.set(3)

long_bit_set = LongBit(size=128)
long_bit_set.long_get(index=5)