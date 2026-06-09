import sys

def main():
    input_data = sys.stdin.read().split()
    iterator = iter(input_data)
    
    size = int(next(iterator))
    graph = [[0] * size for _ in range(size)]
    
    for i in range(size):
        id = int(next(iterator))
        cols = int(next(iterator))
        row = [0] * size
        for j in range(cols):
            col_idx = int(next(iterator)) - 1
            row[col_idx] = 1
        graph[id - 1] = row
    
    for row in graph:
        print(' '.join(map(str, row)))

if __name__ == "__main__":
    main()
