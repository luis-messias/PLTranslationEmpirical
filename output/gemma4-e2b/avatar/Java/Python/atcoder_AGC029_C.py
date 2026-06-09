import sys
from collections import defaultdict

def is_possible(k: int, a: list[int]) -> bool:
    """
    Checks if it is possible to arrange the elements such that the maximum difference 
    between adjacent elements is at most k.
    This function mirrors the logic from the Java implementation using a TreeMap simulation.
    """
    # s acts as the TreeMap, storing {value: count}
    s = defaultdict(int)
    current = 0
    
    for ai in a:
        if ai <= current:
            if k == 1:
                return False
            
            # Simulate s.pollLastEntry() while s.lastKey() >= ai
            # Since we are using defaultdict, we need to find the maximum key dynamically.
            
            # To simulate TreeMap behavior efficiently, we need keys to be ordered.
            # We extract keys, sort them, and iterate, or rely on the fact that 
            # the logic only cares about the maximum key.
            
            # In Java TreeMap, lastKey() gives the largest key.
            
            # We iterate over keys to find the largest one >= ai and remove them.
            keys = sorted(s.keys())
            
            # Find