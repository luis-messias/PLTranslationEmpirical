import sys

def main():
    size = int(input())
    graph = [[0]*size for _ in range(size)]

    id = 0
    cols = 0
    row = [0]*size
    for i in range(size):
        line = input().split()
        id = int(line[0])
        cols = int(line[1])
        row = [0]*size
        for j in range(cols):
            index = int(line[j+2]) - 1
            row[index] = 1
        graph[id-1] = row

    for i in range(size):
        for j in range(size):
            print(graph[i][j], end=' ')
        print()

if __name__ == "__main__":
    main()
