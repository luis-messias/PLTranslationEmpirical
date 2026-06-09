import sys

def main():
    input_data = sys.stdin.read().split()
    E = int(input_data[0])
    Y = int(input_data[1])

    if E == 0:
        if Y <= 1911:
            print("M")
            print(Y - 1867)
        elif Y <= 1925:
            print("T")
            print(Y - 1911)
        elif Y <= 1988:
            print("S")
            print(Y - 1925)
        else:
            print("H")
            print(Y - 1988)
    elif E == 1:
        print(1867 + Y)
    elif E == 2:
        print(1911 + Y)
    elif E == 3:
        print(1925 + Y)
    else:
        print(1988 + Y)

if __name__ == "__main__":
    main()