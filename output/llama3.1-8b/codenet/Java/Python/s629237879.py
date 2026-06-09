import sys

def main():
    n = int(input())
    str_list = []
    for _ in range(n):
        str_list.append(input())

    mark = ["S", "H", "C", "D"]
    for ma in mark:
        for i in range(1, 14):
            st = f"{ma} {i}"
            if st not in str_list:
                print(st)

if __name__ == "__main__":
    main()