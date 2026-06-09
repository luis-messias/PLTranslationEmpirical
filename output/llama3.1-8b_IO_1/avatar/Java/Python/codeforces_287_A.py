import sys

def main():
    str_list = []
    for _ in range(4):
        str_list.append(input())

    u = 0
    while u < 2:
        i = 0
        while i < 2:
            if (str_list[u][i] == str_list[u][i+1] and 
                (str_list[u+1][i] == str_list[u][i] or str_list[u+1][i+1] == str_list[u][i])) or \
               (str_list[u+1][i] == str_list[u+1][i+1] and 
                (str_list[u][i] == str_list[u+1][i] or str_list[u][i+1] == str_list[u+1][i])):
                print("YES")
                return
            i += 1
        u += 1

    print("NO")

if __name__ == "__main__":
    main()
