import math

def main():
    a, b = map(int, input().split())
    digit = int(math.log10(a + b)) + 1
    print(digit)

if __name__ == "__main__":
    while True:
        try:
            main()
        except ValueError:
            break