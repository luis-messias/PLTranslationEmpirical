import sys

def main():
    a = [0] * 100000
    x = 0
    while True:
        try:
            c = int(input())
            mark = input()
            b = int(input())
            if mark == "?":
                a[x] = 2000001
                break
            elif mark == "+":
                a[x] = c + b
            elif mark == "-":
                a[x] = c - b
            elif mark == "*":
                a[x] = c * b
            elif mark == "/":
                if b != 0:
                    a[x] = c // b
                else:
                    print("Error: Division by zero")
                    return
            x += 1
        except ValueError:
            print("Error: Invalid input")
            return

    while True:
        if a[x] == 2000001:
            break
        try:
            print(a[x])
            x += 1
        except IndexError:
            break

if __name__ == "__main__":
    main()