import sys

def main():
    N = int(input())
    s = []
    a_num = 0
    b_num = 0
    flag = True
    ans = 0
    for _ in range(N):
        s.append(input())
        if s[-1][0] == 'B':
            b_num += 1
        if s[-1][-1] == 'A':
            a_num += 1
        if (s[-1][0] == 'B' or s[-1][-1] == 'A') and not (s[-1][0] == 'B' and s[-1][-1] == 'A'):
            flag = False
        for j in range(len(s[-1]) - 1):
            if s[-1][j:j+2] == 'AB':
                ans += 1
    ans += min(a_num, b_num)
    if min(a_num, b_num) != 0 and flag:
        ans -= 1
    print(ans)

if __name__ == "__main__":
    main()