import sys

def main():
    r = int(input())

    if r < 1200:
        print("ABC")
        return
    elif r < 2800:
        print("ARC")
        return
    else:
        print("AGC")

if __name__ == "__main__":
    main()