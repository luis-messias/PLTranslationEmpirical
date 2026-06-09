import sys

def debug(obj):
    # Mimic System.err.println (Arrays.deepToString ( obj ))
    print(repr(obj), file=sys.stderr)

def main():
    # Read input n
    try:
        # Read input from stdin
        line = sys.stdin.readline()
        if not line:
            return
        n = int(line.strip())
    except ValueError:
        return

    square = n * n
    odd = []
    even = []

    # Populate odd and even lists up to square
    # i runs from 1 to square
    for i in range(1, square + 1):
        if i % 2 == 0:
            even.append(i)
        else:
            odd.append(i)

    loop = square // n  # loop = n
    div = loop // 2     # div = n // 2

    debug(div)

    # Main printing loop
    # i runs from 1 to loop (n)
    for i in range(1, loop + 1):
        # j runs from 0 to div - 1
        for j in range(div):
            if i % 2 == 1:
                # i is odd: print odd[0] and even[last]
                # Note: Java uses remove(0) and remove(size()-1)
                
                # Get the first element of odd
                odd_val = odd.pop(0)
                
                # Get the last element of even
                even_val = even.pop()
                
                sys.stdout.write(f"{odd_val} {even_val} ")
            else:
                # i is even: print even[0] and odd[last]
                
                # Get the first element of even
                even_val = even.pop(0)
                
                # Get the last element of odd
                odd_val = odd.pop()
                
                sys.stdout.write(f"{even_val} {odd_val} ")
        
        # Print a newline after the inner loop finishes for each i
        sys.stdout.write("\n")

if __name__ == "__main__":
    main()
