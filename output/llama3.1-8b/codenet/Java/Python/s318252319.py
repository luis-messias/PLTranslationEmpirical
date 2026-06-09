import re

def main():
    s = input()
    n = int(re.search(r'\d$', s).group())
    if n == 3:
        print("bon")
    elif n in [0, 1, 6, 8]:
        print("pon")
    else:
        print("hon")

if __name__ == "__main__":
    main()