import sys

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    iterator = iter(input_data)
    
    try:
        n = int(next(iterator))
        a = [int(next(iterator)) for _ in range(n)]
        b = [0] * n
        s = -1
        tem = 1
        q = 0
        
        while q != n:
            s += 1
            if tem == 1:
                for i in range(n):
                    if a[i] <= q and b[i] == 0:
                        b[i] = 1
                        q += 1
                tem = 0
            else:
                for i in range(n - 1, -1, -1):
                    if a[i] <= q and b[i] == 0:
                        b[i] = 1
                        q += 1
                tem = 1
        
        print(s)
    except StopIteration:
        pass

if __name__ == "__main__":
    main()
