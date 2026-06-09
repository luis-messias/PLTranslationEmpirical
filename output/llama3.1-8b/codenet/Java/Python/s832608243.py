import math

def main():
    a, b = map(int, input().split())
    flag = False
    for i in range(1, 100001):
        if math.floor(i * 0.08) == a and math.floor(0.1 * i) == b:
            print(i)
            flag = True
            break
    if not flag:
        print(-1)

if __name__ == "__main__":
    main()