import sys
def revpos(p, q):
    vec = [p[0] - q[0], p[1] - q[1]]
    tmp = vec[0]
    vec[0] = vec[1]
    vec[1] = -tmp
    newpos = [q[0] + vec[0], q[1] + vec[1]]
    return newpos

def main():
    input = list(map(int, sys.stdin.readline().split()))
    position = [[0, 0], [0, 0], [0, 0], [0, 0]]
    position[0][0] = input[0]
    position[0][1] = input[1]
    position[1][0] = input[2]
    position[1][1] = input[3]
    position[2] = revpos(position[0], position[1])
    position[3] = revpos(position[1], position[2])
    if position[0] == revpos(position[2], position[3]):
        print("OK")
    output = [position[2][0], position[2][1], position[3][0], position[3][1]]
    for i in output:
        print(i)

if __name__ == "__main__":
    main()
