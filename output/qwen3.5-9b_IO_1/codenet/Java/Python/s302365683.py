import sys
from collections import Counter

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    values = input_data[1:n+1]
    
    hm = Counter(values)
    
    ans = 0
    for val, num in hm.items():
        if num > int(val):
            ans += num - int(val)
        elif num < int(val):
            ans += num
    
    print(ans)

if __name__ == "__main__":
    main()
