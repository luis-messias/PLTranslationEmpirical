import sys

def main():
    number = int(input())
    ans = -1
    value = 0
    mask = 2
    while value < number:
        s = bin(mask)[2:]
        zeros = sum(c == '0' for c in s)
        if zeros != len(s) - zeros:
            continue
        s = s.replace('0', '4').replace('1', '7')
        value = int(s, 16)
        mask += 1

    print(value)

if __name__ == "__main__":
    main()