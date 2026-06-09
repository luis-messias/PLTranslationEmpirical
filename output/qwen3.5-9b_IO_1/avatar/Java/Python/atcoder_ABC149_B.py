import sys

def main():
    tokens = sys.stdin.readline().split()
    A = int(tokens[0])
    B = int(tokens[1])
    K = int(tokens[2])
    
    x = A
    y = B
    x = A - K
    if x < 0:
        y = B + x
        x = 0
        if y < 0:
            y = 0
    
    print(x, y)

if __name__ == "__main__":
    main()
