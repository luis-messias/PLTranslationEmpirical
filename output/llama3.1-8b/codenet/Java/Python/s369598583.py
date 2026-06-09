import sys

def main():
    N = int(input())
    count = 0
    next_num = 10
    for i in range(1, N + 1):
        count += 1
        if i == next_num - 1:
            i = next_num * 10 - 1
            next_num *= 100
    print(count)

if __name__ == "__main__":
    main()