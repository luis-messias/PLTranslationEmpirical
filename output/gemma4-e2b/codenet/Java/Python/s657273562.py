import sys
from collections import defaultdict
import math

# Set recursion limit higher for safety, although not strictly necessary for this specific logic
# sys.setrecursionlimit(2000)

class Pair:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __lt__(self, other):
        # Implements the comparison logic from Java's compareTo
        min1 = min(self.x, self.y)
        min2 = min(other.x, other.y)
        if min1 != min2:
            return min1 - min2
        if self.x != other.x:
            return self.x - other.x
        return self.y - other.y

    def __eq__(self, other):
        if not isinstance(other, Pair):
            return NotImplemented
        return self.x == other.x and self.y == other.y

    def __hash__(self):
        # Hash based on the pair values
        return hash((self.x, self.y))

    def __repr__(self):
        return f"{self.x} {self.y}"

    def add(self, other):
        self.x += other.x
        self.y += other.y

class Main:
    def ceildiv(self, x, y):
        # Equivalent to (x+y-1)/y for positive integers
        return (x + y - 1) // y

    def mod(self, x, m):
        # Equivalent to (x % m + m) % m
        return (x % m + m) % m

    def gcd(self, x, y):
        while y:
            x, y = y, x % y
        return x

    def Int(self, x):
        return 1 if x else 0

    def put(self, map_dict, p):
        # Updates count in the map
        if p in map_dict:
            map_dict[p] += 1
        else:
            map_dict[p] = 1

    def rem(self, map_dict, p):
        # Decrements count in the map
        if p in map_dict:
            if map_dict[p] == 1:
                del map_dict[p]
            else:
                map_dict[p] -= 1

    def fill(self, arr, x):
        # Equivalent to arr[i] += ((1 << i) & x)
        for i in range(30):
            if (x >> i) & 1:
                arr[i] += 1

    def pow(self, a, pow_val):
        # Calculates a^pow_val
        ans = 1
        a = a
        while pow_val > 0:
            if pow_val & 1:
                ans *= a
            a *= a
            pow_val >>= 1
        return ans

    def getpow(self, x):
        # This function seems highly specific to the custom input reading flow in Java.
        # Since we are translating the logic, we focus on the mathematical result if possible,
        # but the Java implementation involves complex I/O interaction.
        # We will skip direct translation of the complex I/O interaction unless necessary for the core algorithm.
        # For competitive programming context, we assume standard input reading handles the flow.
        pass

    def linearsieve(self, x):
        # Sieve of Eratosthenes variant to find the least prime factor (LPF)
        least = [0] * (x + 1)
        prime = set()
        for i in range(2, x + 1):
            if least[i] == 0:
                least[i] = i
                prime.add(i)
            for y in prime:
                if i * y <= x:
                    # This logic seems to find the smallest factor, not necessarily the LPF in the standard sense,
                    # but we replicate the structure.
                    if least[i * y] == 0:
                        least[i * y] = y
                else:
                    break

    def solve(self):
        # Simulate reading input from stdin
        try:
            data = sys.stdin.read().split()
        except Exception:
            return

        if not data:
            return

        # The Java code reads N, then an array of N integers.
        if not data:
            return

        n = int(data[0])
        arr = [int(x) for x in data[1:n+1]]

        if n >= 3:
            # TreeMap<Pair, Integer> map=new TreeMap<>(Collections.reverseOrder());
            # In Python, we use a dict and rely on sorting keys or use a structure that maintains order.
            # Since the Java code uses TreeMap with reverse order, we use a standard dict and manage keys.
            # We use a dictionary to store counts of pairs.
            map_dict = defaultdict(int)
            
            # arr is already sorted in reverse order by the Java code: Arrays.sort(arr, Collections.reverseOrder());
            # The input reading in Java was: Integer[] arr=sc.nextsort(n); followed by Arrays.sort(arr, Collections.reverseOrder());
            # If the input reading was sequential, arr is the input sequence.
            
            # Let's assume the input reading provided the numbers in the order they were read.
            # The Java code sorts the input array:
            # Arrays.sort(arr)
            
            # We must sort the input array first to match