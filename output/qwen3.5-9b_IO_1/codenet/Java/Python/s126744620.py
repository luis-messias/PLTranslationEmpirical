import sys
from collections import Counter

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    k = int(input_data[1])
    a = [int(x) for x in input_data[2:2+n]]
    
    count = Counter(a)
    
    # Find minimum value that appears at least k times
    ans = float('inf
