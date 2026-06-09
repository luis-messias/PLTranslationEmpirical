import sys
def main():
    n, m = map(int, input().split())
    ans = []
    for i in range(n):
        str = input()
        temp = ""
        for j in range(m):
            if str[j] == '-':
                temp += "-"
            else:
                if (i + j) % 2 == 1:
                    temp += "W"
                else:
                    temp += "B"
        ans.append(temp)
    for i in ans:
        print(i)

if __name__ == "__main__":
    main()
