Here's a direct translation of the provided Java code into Python. Note that some parts might need adjustments due to differences in syntax and libraries used between Java and Python.


import sys
from collections import deque
import math
import random
import bisect
import itertools
import functools
from typing import List, Tuple

class FastScanner:
    def __init__(self):
        self.inp = sys.stdin.readline

    def next(self) -> str:
        return self.inp().strip()

    def next_int(self) -> int:
        return int(self.next())

    def next_long(self) -> int:
        return int(self.next())

    def next_double(self) -> float:
        return float(self.next())

    def ni(self, array: List[int]) -> None:
        for i in range(len(array)):
            array[i] = self.next_int()

    def nl(self, array: List[int]) -> None:
        for i in range(len(array)):
            array[i] = self.next_long()

    def nisan(self, array2d: List[List[int]]) -> None:
        for i in range(len(array2d)):
            for j in range(len(array2d[0])):
                array2d[i][j] = self.next_int()

def gcd(a: int, b: int) -> int:
    if a == 0:
        return b
    return gcd(b % a, a)

def lcm(a: int, b: int) -> int:
    return (a * b) // gcd(a, b)

def is_prime(n: int) -> bool:
    if n <= 1:
        return False
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True

def powmod(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod2(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod3(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod4(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod5(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod6(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod7(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod8(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod9(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod10(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod11(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod12(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod13(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod14(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod15(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod16(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod17(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod18(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod19(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod20(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod21(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod22(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod23(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result = (result * base) % mod
        base = (base * base) % mod
        exp >>= 1
    return result

def powmod24(base: int, exp: int, mod: int) -> int:
    result = 1
    while exp > 0:
        if exp & 1:
            result =