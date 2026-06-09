import sys
from collections import Counter

def reverse(ch):
    """Reverses the case of a character."""
    if ch.islower():
        return ch.upper()
    else:
        return ch.lower()

def solve():
    # Read all input tokens (assuming two space-separated strings s and t)
    try:
        data = sys.stdin.read().split()
        if len(data) < 2:
            s = ""
            t = ""
        else:
            s = data[0]
            t = data[1]
    except Exception:
        s = ""
        t = ""

    # 1. Calculate frequency map of t
    tmap = Counter(t)
    
    ura = 0
    opa = 0
    
    # 2. Calculate ura (matching s characters directly)
    for char_s in s:
        if tmap.get(char_s, 0) > 0
