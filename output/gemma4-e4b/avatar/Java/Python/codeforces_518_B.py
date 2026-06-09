import sys
from collections import Counter

def reverse(ch):
    """Reverses the case of a character."""
    if ch.islower():
        return ch.upper()
    else:
        return ch.lower()

def solve():
    # Read all input tokens (assuming two space-separated strings)
    try:
        input_data = sys.stdin.read().split()
        if len(input_data) < 2:
            s = ""
            t = ""
        else:
            s = input_