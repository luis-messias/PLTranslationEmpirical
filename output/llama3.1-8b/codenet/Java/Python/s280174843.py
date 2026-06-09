import sys
import re

def main():
    inp = input().split()
    abc = [int(x) for x in inp]
    if abc[0] < abc[1] and abc[1] < abc[2]:
        print("Yes")
    else:
        print("No")

if __name__ == "__main__":
    main()