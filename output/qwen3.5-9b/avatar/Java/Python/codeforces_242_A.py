import sys

def main():
    x = int(input())
    y = int(input())
    a = int(input())
    b = int(input())
    
    count = 0
    for i in range(a, x + 1):
        for j in range(b, y + 1):
            if i <= j:
                continue
            count += 1
    
    print(count)
    
    for i in range(a, x + 1):
        for j in range(b, y + 1):
            if i <= j:
                continue
            print(i, j)

if __name__ == "__main__":
    main()