import sys

def main():
    c = input()
    letter = ord(c[0])
    letter += 1

    print(chr(letter))

if __name__ == "__main__":
    main()