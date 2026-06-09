import sys

def main():
    input_data = sys.stdin.read().split()
    E = int(input_data[0])
    Y = int(input_data[1])

    if E == 0:
        if Y <= 1911:
            sys.stdout.write("M")
            sys.stdout.write(str(Y - 1867))
        elif Y <= 1925:
            sys.stdout.write("T")
            sys.stdout.write(str(Y - 1911))
        elif Y <= 1988:
            sys.stdout.write("S")
            sys.stdout.write(str(Y - 1925))
        else:
            sys.stdout.write("H")
            sys.stdout.write(str(Y - 1988))
    elif E == 1:
        sys.stdout.write(str(1867 + Y))
    elif E == 2:
        sys.stdout.write(str(1911 + Y))
    elif E == 3:
        sys.stdout.write(str(1925 + Y))
    else:
        sys.stdout.write(str(1988 + Y))

if __name__ == "__main__":
    main()
