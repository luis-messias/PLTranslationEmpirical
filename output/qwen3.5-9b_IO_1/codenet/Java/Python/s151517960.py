import sys
from collections import Counter

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    nums = [int(x) for x in input_data[1:n+1]]
    
    count = Counter(nums)
    ans = sum(1 for v in count.values() if v % 2 == 1)
    
    print(ans)

if __name__ == "__main__":
    main()
