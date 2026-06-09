import sys

def main():
    str_list = []
    for _ in range(4):
        str_list.append(input())

    for i in range(2):
        for j in range(2):
            if (str_list[i][j] == str_list[i][j+1] and 
                (str_list[i+1][j] == str_list[i][j] or str_list[i+1][j+1] == str_list[i][j])) or \
               (str_list[i+1][j] == str_list[i+1][j+1] and 
                (str_list[i][j] == str_list[i+1][j] or str_list[i][j+1] == str_list[i+1][j])):
                print("YES")
                return

    print("NO")

if __name__ == "__main__":
    main()