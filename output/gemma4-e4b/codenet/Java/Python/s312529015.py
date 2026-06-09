import sys

def main():
    # Read all lines from standard input and convert them to integers
    try:
        input_data = sys.stdin.read().split()
        if len(input_data) < 2:
            return
        
        A = int(input_data[0])
        B = int(input_data[1])
    except ValueError:
        return

    if A % 3 == 0 or B % 3 == 0 or (A + B) % 3 == 0:
        print("Possible")
    else:
        print("Impossible")

if __name__ == "__main__":
    main()