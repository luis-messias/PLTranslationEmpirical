import sys

def main():
    # Read input a
    try:
        a = int(sys.stdin.readline())
    except:
        return

    # Read input b
    try:
        b = int(sys.stdin.readline())
    except:
        return

    # Calculate hb (integer division)
    hb = b // 2
    
    # Output
    print(a + hb)

if __name__ == "__main__":
    main()