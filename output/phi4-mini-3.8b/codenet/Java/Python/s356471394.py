import sys

def main():
    input_data = sys.stdin.read().strip()
    nums, room_strs = zip(*[line.split() for line in input_data.strip().split('\n')])

    N, M, D = map(int, nums)
    num = 0
    
    if len(room_strs) != N:
        raise ValueError("Number of rows does not match the specified size.")

    room = [list(row) for row in room_strs]

    inputRoom()

    if M >= D:
        setWE()
    
    if N >= D:
        setNS()

    print(num)

def setWE():
    global num
    canPut = True

    for i in range(N):
        for j in range(M - D + 1):
            canPut = True
            
            for k in range(D):
                if room[i][j + k] == '#':
                    canPut = False
                    break
                
            if canPut:
                num += 1

def setNS():
    global num
    canPut = True
    
    for i in range(M):
        for j in range(N - D + 1):
            canPut = True
            
            for k in range(D):
                if room[j + k][i] == '#':
                    canPut = False
                    break
                
            if canPut:
                num += 1

def inputRoom():
    global N, M, D
    str_room = ""
    
    for i in range(N):
        str_room = sys.stdin.readline().strip()
        
if __name__ == "__main__":
    main()