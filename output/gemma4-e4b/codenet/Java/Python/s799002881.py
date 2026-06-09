import math
import sys

def main():
    # Read N and D from the first line of standard input
    try:
        line = sys.stdin.readline().strip()
        if not line:
            return
        
        parts = line.split()
        N = int(parts[0])
        D = float(parts[1])
    except Exception:
        return

    count = 0
    
    # Process the next N lines