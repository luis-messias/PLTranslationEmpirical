import sys

def main():
    for i in range(5):
        num = int(input())
        if num == 0:
            print(i + 1)
            break

if __name__ == "__main__":
    main()