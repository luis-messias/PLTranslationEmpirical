import sys

def main():
    line = input().split()
    x = int(line[0])
    y = int(line[1])
    a = int(line[2])
    b = int(line[3])
    
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
