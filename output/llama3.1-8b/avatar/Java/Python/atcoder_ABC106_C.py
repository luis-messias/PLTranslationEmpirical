import sys

def main():
    str = input()
    k = int(input())
    for i in range(k):
        if str[i] == '1':
            if i == k - 1:
                print(1)
                return
        else:
            print(str[i])
            return

if __name__ == "__main__":
    main()