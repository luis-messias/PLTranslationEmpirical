import sys

def main():
    a = []
    while True:
        try:
            line = input().split()
            c = int(line[0])
            mark = line[1]
            b = int(line[2])
            
            if mark == "?":
                break
            elif mark == "+":
                a.append(c + b)
            elif mark == "-":
                a.append(c - b)
            elif mark == "*":
                a.append(c * b)
            elif mark == "/":
                a.append(c // b)
        except EOFError:
            break
    
    for result in a:
        print(result)

if __name__ == "__main__":
    main()
