import sys

def main():
    """
    Reads numbers as strings from standard input, calculates the sum of their digits, 
    and prints the sum until "0" is encountered.
    """
    for line in sys.stdin:
        inputed = line.strip()
        
        if not inputed:
            continue
            
        if inputed == "0":
            break
        
        # Calculate the sum of digits
        ans = 0
        for char in inputed:
            ans += int(char)
            
        print(ans)

if __name__ == "__main__":
    main()