import sys

def main():
    input = sys.stdin.read
    data = input().split()
    idx = 0
    
    n = int(data[idx])
    idx += 1
    k = int(data[idx])
    idx += 1
    
    arr = []
    for i in range(n):
        arr.append(int(data[idx]))
        idx += 1
    
    o = 0  # count of 1s
    e = 0  # count of -1s
    
    for x in arr:
        if x == 1:
            o += 1
        else:
            e += 1
    
    res = []
    for i in range(k):
        l = int(data[idx])
        idx += 1
        r = int(data[idx])
        idx += 1
        
        length = r - l + 1
        
        if length % 2 == 1:
            res.append("0")
        else:
            needed = length // 2
            if needed <= o and needed <= e:
                res.append("1")
            else:
                res.append("0")
    
    for r in res:
        print(r)

if __name__ == "__main__":
    main()
