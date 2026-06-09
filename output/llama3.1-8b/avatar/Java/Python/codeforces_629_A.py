import sys

def main():
    num = int(input())
    arr = []
    for _ in range(num):
        s = input()
        arr.append(s)

    fine = 0
    for i in range(num):
        counter = 0
        for k in range(num):
            if arr[k][i] == 'C':
                counter += 1
        fine += (counter * (counter - 1)) // 2

    for i in range(num):
        counter = 0
        for k in range(num):
            if arr[i][k] == 'C':
                counter += 1
        fine += (counter * (counter - 1)) // 2

    print(fine)

if __name__ == "__main__":
    main()