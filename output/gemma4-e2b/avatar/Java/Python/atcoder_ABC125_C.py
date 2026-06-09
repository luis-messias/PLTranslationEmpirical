import sys

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    N