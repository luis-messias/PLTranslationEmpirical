import sys

def main():
    n = int(input())
    s1, s2 = 0, 0
    flag = False
    dif = 0
    ch = []

    for _ in range(n):
        x, y = map(int, input().split())
        temp1 = s1 + x
        temp2 = s2 + y

        if abs(temp1 - s2) <= 500:
            s1 += x
            ch.append('A')
            continue
        if abs(temp2 - s1) <= 500:
            s2 += y
            ch.append('G')
            continue
        flag = True
        break

    if flag:
        print(-1)
    else:
        ans = ''.join(ch)
        print(ans)

if __name__ == "__main__":
    main()