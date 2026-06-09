import sys

def main():
    # Read input line by line from standard input
    for line in sys.stdin:
        input_line = line.strip()
        
        if not input_line:
            continue
            
        if input_line == "0":
            break
            
        ans = 0
        # Calculate the sum of the digits in the input string
        for char in input_line:
            ans += int(char)
            
        print(ans)

if __name__ == "__main__":
    main()