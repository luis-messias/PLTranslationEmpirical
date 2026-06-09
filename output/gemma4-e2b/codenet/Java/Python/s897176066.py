import sys

def main():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # The first element is N