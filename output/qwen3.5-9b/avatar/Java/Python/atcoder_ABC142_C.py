import sys

def main():
    input = sys.stdin.read
    data = input().split()
    iterator = iter(data)
    
    N = int(next(iterator))
    
    idorder = {}
    for i in range(1, N + 1):
        A = int(next(iterator))
        idorder[A] = i
    
    for i in range(1, N + 1):
        print(idorder[i], end=' ')

if __name__ == "__main__":
    main()