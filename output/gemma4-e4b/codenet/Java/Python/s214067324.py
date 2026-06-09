import sys

def main():
    try:
        # Read the single integer input from standard input
        x = int(sys.stdin.read().strip())
        
        # Print "ABC" if x < 1200, otherwise print "ARC"
        print("ABC" if x < 1200 else "ARC")
    except EOFError:
        # Handle case where no input is provided
        pass

if __name__ == "__main__":
    main()