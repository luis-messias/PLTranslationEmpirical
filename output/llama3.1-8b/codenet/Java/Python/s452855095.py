import sys

def main():
    n = int(input())
    arr = [int(input()) for _ in range(n)]
    cnt = 0
    flag = True
    while True:
        for i in range(n):
            if arr[i] % 2 != 0:
                flag = False
                break
            else:
                arr[i] //= 2
        if flag:
            cnt += 1
        else:
            break
    print(cnt)

if __name__ == "__main__":
    main()