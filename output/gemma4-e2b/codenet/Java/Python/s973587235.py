import sys

def solve():
    # Read all input tokens
    try:
        data = sys.stdin.read().split()
    except:
        return

    if len(data) < 2:
        return

    try: