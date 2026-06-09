import sys

BIG_NUM = 2000000000
MOD = 1000000007

def main():
    while True:
        try:
            inputed = input()
            if len(inputed) == 1 and inputed == '0':
                break

            ans = 0
            for char in inputed:
                ans += int(char)
            print(ans)

        except Exception as e:
            print(e)

if __name__ == "__main__":
    main()