import sys

def main():
    input_data = sys.stdin.read().split()
    a = int(input_data[0])
    b = int(input_data[1])
    c = int(input_data[2])
    d = int(input_data[3])
    
    if c > b:
        print(0)
    elif a > d:
        print(0)
    elif a < c:
        print(min(b, d) - c)
    else:
        l = [a, b, c, d]
        l.sort()
        print(l[2] - l[1])

if __name__ == "__main__":
    main()