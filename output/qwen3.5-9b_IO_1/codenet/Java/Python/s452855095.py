import sys

def main():
    n = int(sys.stdin.readline())
    arr = list(map(int, sys.stdin.readline().split()))
    
    cnt = 0
    while True:
        flag = True
        for i in range(n):
            if arr[i] % 2 != 0:
                flag = False
                break
            else:
                arr[i] = arr[i] // 2
        if flag:
            cnt += 1
        else:
            break
    
    print(cnt)

if __name__ == "__main__":
    main()
