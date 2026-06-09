import math

def main():
    n = int(input())
    str = input()
    l = list(str)
    
    t = 0
    for i in range(n):
        if l[i] not in ['4', '7']:
            t = 1
    
    if t == 1:
        print("NO")
    else:
        x = sum(int(c) for c in l[:n//2])
        y = sum(int(c) for c in l[n//2:][::-1])
        
        if x == y:
            print("YES")
        else:
            print("NO")

if __name__ == "__main__":
    main()