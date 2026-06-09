from collections import defaultdict

def main():
    num_node, num_edge = map(int, input().split())
    connect = [[] for _ in range(num_node)]
    for i in range(num_edge):
        a, b = map(lambda x: int(x) - 1, input().split())
        connect[a].append(b)
        connect[b].append(a)

    if num_edge % 2 != 0:
        print(-1)
        return

    visited = [0] * num_node
    odd = [False] * num_node
    print_str = []

    def dfs(crt, parent):
        visited[crt] = 1
        for child in connect[crt]:
            if child == parent or visited[child] == 1:
                continue
            elif visited[child] == 2:
                print_str.append(f"{crt + 1} {child + 1}\n")
                odd[crt] = not odd[crt]
            else:
                dfs(child, crt)
                if odd[child]:
                    print_str.append(f"{child + 1} {crt + 1}\n")
                    odd[child] = not odd[child]
                else:
                    print_str.append(f"{crt + 1} {child + 1}\n")
                    odd[crt] = not odd[crt]

        visited[crt] = 2

    dfs(0, -1)
    print(''.join(print_str))

main()