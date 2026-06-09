import sys

def main():
    input_data = sys.stdin.read().split()
    iterator = iter(input_data)
    
    n = int(next(iterator))
    
    for _ in range(n):
        a = [int(next(iterator)) for _ in range(3)]
        a.sort()
        if a[2]**2 == a[0]**2 + a[1]**2:
            print("YES")
        else:
            print("NO")

if __name__ == "__main__":
    main()
