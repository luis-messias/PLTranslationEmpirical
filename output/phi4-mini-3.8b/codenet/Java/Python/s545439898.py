import sys

if __name__ == "__main__":
    count = int(sys.stdin.readline().strip())
    
    giving_numbers = [int(x) for x in sys.stdin.readlines() if not x.isspace()][0:count]
    
    # Reversing Numbers and printing with space between them (except the first number)
    output = ' '.join(map(str, given_numbers[::-1])
    print(output)