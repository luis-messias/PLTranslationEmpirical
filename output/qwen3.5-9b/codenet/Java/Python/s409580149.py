import sys
from typing import List

# Constants
mod = 10**9 + 7

# Math helpers
def min(x, y):
    return min(x, y)

def max(x, y):
    return max(x, y)

def max(x, y, z):
    return max(max(x, y), z)

def min(x, y, z):
    return min(min(x, y), z)

# Array operations
def sort(arr):
    arr.sort()

def rsort(arr):
    arr.sort()
    arr.reverse()

def fill(arr, x):
    for i in range(len(arr)):
        arr[i] = x

# Modular arithmetic
def plus(x, y):
    res = (x + y) % mod
    return res if res >= 0 else res + mod

def sub(x, y):
    res = (x - y) % mod
    return res if res >= 0 else res + mod

def mul(x, y):
    res = (x * y) % mod
    return res if res >= 0 else res + mod

def div(x, y):
    res = x * pow(y, mod - 2, mod) % mod
    return res if res >= 0 else res + mod

def pow(x, y):
    if y < 0:
        return 0
    if y == 0:
        return 1
    if y % 2 == 1:
        return (x * pow(x, y - 1)) % mod
    root = pow(x, y // 2)
    return (root * root) % mod

# Input reading (fast I/O)
def ni():
    return int(sys.stdin.read().split()[0])

def nl():
    return int(sys.stdin.read().split()[0])

def ns():
    return sys.stdin.read().split()[0]

def solve():
    # Main solution function
    pass

if __name__ == "__main__":
    solve()