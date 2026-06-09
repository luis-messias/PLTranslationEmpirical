import re

def main():
    n = int(input())
    num = list(range(1, n + 1))
    count = int(input())
    
    for _ in range(count):
        line = input().strip()
        parts = line.split(',')
        line[0] = int(parts[0]) - 1
        line[1] = int(parts[1]) - 1
        
        change = num[line[0]]
        num[line[0]] = num[line[1]]
        num[line[1]] = change
    
    for i in num:
        print(i)

if __name__ == "__main__":
    main()
