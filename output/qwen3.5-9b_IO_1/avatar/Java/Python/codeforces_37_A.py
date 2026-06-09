import sys
from collections import Counter

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    nums = input_data[1:n+1]
    
    freq = Counter(nums)
    max_freq = max(freq.values())
    print(max_freq, len(freq))

if __name__ == "__main__":
    main()
