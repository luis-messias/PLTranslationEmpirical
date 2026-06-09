import sys

def main():
    lines = sys.stdin.readlines()
    first_line = lines[0].split()
    n = int(first_line[0])
    d = int(first_line[1])
    cnt = 0
    
    for i in range(1, n + 1):
        line = lines[i].split()
        x = int(line[0])
        y = int(line[1])
        if (x*x + y*y) <= d*d:
            cnt += 1
    
    print(cnt)

if __name__ == "__main__":
    main()
