from decimal import Decimal
import sys

def main():
    sa = input()
    sb = input()
    A = Decimal(sa)
    B = Decimal(sb)
    print(A * B)

if __name__ == "__main__":
    main()