import sys

def debug(*obj):
    # Fix: Instead of printing the tuple representation (which caused the error), 
    # we print the actual value of the argument passed (assuming it's the first element).
    if obj:
        print(obj[0], file=sys.stderr)

def solve():
