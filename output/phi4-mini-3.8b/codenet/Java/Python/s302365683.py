import sys

def main():
    input = sys.stdin.read
    data = input().splitlines()
    
    n = int(data[0])
    hm = {}
    
    for i in range(1, 2 * (n // 2) + 1):
        val = int(data[i])
        if val not in hm:
            hm[val] = 0
        hm[val] += 1
    
    ans = 0
    keys_sorted = sorted(hm.keys())
    
    for i, key in enumerate(keys_sorted[:-1]):
        next_key = keys_sorted[i + 1]
        num = hm[key]
        
        if num > key:
            ans += (num - key)
        elif num < key and not any(k == key or k == next_key for k in range(key)):
            ans += min(num, next_key)

    print(ans)


if __name__ == "__main__":
    main()