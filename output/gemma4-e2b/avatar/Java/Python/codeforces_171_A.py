import sys

def reverse(n):
    if n < 10:
        return n * 10
    
    t = n
    r = 0
    while t > 0:
        r = (r * 10) + t % 10
        t = t // 10
    return r

def main():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if len(data) >= 2:
        n = int(data[0])
        m = int(data[1])
        
        t = reverse(m)
        print(t + n)

if __name__ == "__main__":
    main()