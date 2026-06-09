import sys

def main():
    while True:
        try:
            s = input()
            if s == "0":
                break
            sum_val = 0
            for char in s:
                sum_val += int(char)
            print(sum_val)
        except ValueError:
            pass

if __name__ == "__main__":
    main()