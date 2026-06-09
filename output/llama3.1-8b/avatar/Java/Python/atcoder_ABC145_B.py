import math

def cout(str):
    print(str)

def main():
    n = int(input())
    str = input()
    a = ""
    for i in range(n // 2):
        a += str[i]
    if str == a * 2:
        cout("Yes")
    else:
        cout("No")

if __name__ == "__main__":
    main()