import sys

def solve():
    # Read the input string from standard input
    try:
        s = sys.stdin.read().strip()
    except EOFError:
        s = ""
    
    if not s: