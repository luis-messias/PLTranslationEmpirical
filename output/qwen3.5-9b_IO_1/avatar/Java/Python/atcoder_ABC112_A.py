import sys

def main():
    try:
        n = int(input())
        if n == 1:
            print("Hello World")
        else:
            a = int(input())
            b = int(input())
            print(a + b)
    except:
        pass

if __name__ == "__main__":
    main()
