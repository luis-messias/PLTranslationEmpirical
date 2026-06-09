import sys

def main():
    input_data = sys.stdin.read().split()
    a = [int(x) for x in input_data[:5]]
    
    r = [x % 10 for x in a]
    
    # Dictionary to store (10 - remainder) -> number
    map = {}
    
    for i in range(5):
        if r[i] != 0:
            b = 10 - r[i]
            map[b] = a[i]
    
    ans = 0
    
    if len(map) == 0:
        for i in range(5):
            ans += a[i]
        print(ans)
        return
    
    # Get the number with the largest (10 - remainder)
    last = map[max(map.keys())]
    
    # Find index of this number
    idx = 0
    for i in range(5):
        if a[i] == last:
            idx = i
    
    for i in range(5):
        if i != idx:
            if a[i] % 10 == 0:
                ans += a[i]
            else:
                ans += a[i] + (10 - r[i])
    
    ans += last
    print(ans)

if __name__ == "__main__":
    main()