import sys

def main():
    # Simulate reading 5 integers sequentially from standard input
    for i in range(5):
        try:
            # Read the next integer from stdin
            line = sys.stdin.readline()
            if not line:
                break
            num = int(line.strip())
            
            if num == 0:
                print(i + 1)
                break
        except ValueError:
            # Handle case where input is not an integer
            break
        except EOFError:
            # Handle end of file
            break

if __name__ == "__main__":
    main()