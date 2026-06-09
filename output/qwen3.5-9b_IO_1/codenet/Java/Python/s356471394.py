import sys

def main():
    # Read N, M, D
    line1 = sys.stdin.readline().split()
    N = int(line1[0])
    M = int(line1[1])
    D = int(line1[2])
    
    # Read room grid
    room = []
    for i in range(N):
        room.append(list(sys.stdin.readline().strip()))
    
    num = 0
    
    # Check horizontal placements
    for i in range(N):
        for j in range(M - D + 1):
            can_put = True
            for k in range(D):
                if room[i][j + k] == '#':
                    can_put = False
                    break
            if can_put:
                num += 1
    
    # Check vertical placements
    for i in range(M):
        for j in range(N - D + 1):
            can_put = True
            for k in range(D):
                if room[j + k][i] == '#':
                    can_put = False
                    break
            if can_put:
                num += 1
    
    print(num)

if __name__ == "__main__":
    main()
