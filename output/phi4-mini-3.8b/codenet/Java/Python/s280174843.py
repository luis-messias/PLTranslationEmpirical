import sys

def main():
    abc = [int(x) for x in input().split()]
    
    if len(abc) == 3 and abc[0] < abc[1] < abc[2]:
        print("Yes")
    else:
        print("No")

if __name__ == "__main__":
    sys.stdin.readline()