import heapq
import sys

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    
    if not data:
        return
        
    try:
        n = int(data[0])
    except ValueError:
        return

    if n == 0:
        return

    # Extract the next n numbers
    if len(data) < n + 1:
        return
        
    numbers = [int(x) for x in data[1:
