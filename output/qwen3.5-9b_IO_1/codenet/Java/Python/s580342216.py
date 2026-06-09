import sys

def main():
    line = sys.stdin.readline()
    parts = line.split()
    N = int(parts[0])
    K = int(parts[1])
    
    len_count = 0
    while N > 0:
        N //= K
        len_count += 1
    
    print(len_count)

if __name__ == "__main__":
    main()
