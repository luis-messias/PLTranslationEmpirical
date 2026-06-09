import sys
sys.setrecursionlimit(200000)

def main():
    input_data = sys.stdin.read().split()
    iterator = iter(input_data)
    
    numNode = int(next(iterator))
    numEdge = int(next(iterator))
    
    connect = [[] for _ in range(numNode)]
    
    for _ in range(numEdge):
        a = int(next(iterator)) - 1
        b = int(next(iterator)) - 1
        connect[a].append(b)
        connect[b].append(a)
    
    if numEdge % 2 != 0:
        print(-1)
        return
    
    visited = [0] * numNode
    odd = [False] * numNode
    print_list = []
    
    def dfs(crt, parent):
        visited[crt] = 1
        for child in connect[crt]:
            if child == parent or visited[child] == 1:
                continue
            elif visited[child] == 2:
                print_list.append((crt + 1, child + 1))
                odd[crt] = not odd[crt]
            else:
                dfs(child, crt)
                if odd[child]:
                    print_list.append((child + 1, crt + 1))
                    odd[child] = not odd[child]
                else:
                    print_list.append((crt + 1, child + 1))
                    odd[crt] = not odd[crt]
        visited[crt] = 2
    
    dfs(0, -1)
    
    for u, v in print_list:
        print(f"{u} {v}")

if __name__ == "__main__":
    main()