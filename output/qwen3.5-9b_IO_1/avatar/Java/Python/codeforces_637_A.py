import sys
from collections import Counter

def main():
    n = int(sys.stdin.readline())
    ara = list(map(int, sys.stdin.readline().split()))
    
    # Count frequencies
    freq = Counter(ara)
    max_freq = max(freq.values())
    
    # Find the first number with max frequency
    for num in ara:
        if freq[num] == max_freq:
            print(num)
            break

if __name__ == "__main__":
    main()
