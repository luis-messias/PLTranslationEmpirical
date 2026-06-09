import sys

def main():
    input_data = sys.stdin.read().split()
    idx = 0
    N = int(input_data[idx])
    idx += 1
    M = int(input_data[idx])
    idx += 1
    
    black = [[0] * (N + 2) for _ in range(N + 2)]
    
    for m in range(1, M + 1):
        x = int(input_data[idx])
        idx += 1
        y = int(input_data[idx])
        idx += 1
        
        for xx in range(x - 1, x + 2):
            for yy in range(y - 1, y + 2):
                black[xx][yy] += 1
                if black[xx][yy] == 9:
                    print(m)
                    return
    
    print("-1")

if __name__ == "__main__":
    main()
