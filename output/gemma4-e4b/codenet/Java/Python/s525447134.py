import sys

def main():
    try:
        s = sys.stdin.readline().strip()
    except EOFError:
        return

    if s == "Sunny":
        print("Cloudy")
    elif s == "Cloudy":
        print("Rainy")
    else:
        print("Sunny")

if __name__ == "__main__":
    main()