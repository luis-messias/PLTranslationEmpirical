import sys

def main():
    x = 0
    a = [None] * 100000
    
    for line in iter(sys.stdin.readline, ''):
        c = int(line)
        mark = input().strip()
        b = int(input())
        
        if mark == "?":
            a[x] = float('inf')
            break
        
        elif mark == "+":
            a[x] = c + b
        elif mark == "-":
            a[x] = c - b
        elif mark == "*":
            a[x] = c * b
        elif mark == "/":
            if b != 0: # Avoid division by zero error
                a[x] = float(c) / b
        
        x += 1

    for i in range(x):
        print(a[i])

if __name__ == "__main__":
    main()