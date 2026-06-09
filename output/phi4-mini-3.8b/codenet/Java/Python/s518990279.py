import sys

def main():
    while True:
        inputed = next(sys.stdin)
        if len(inputed) == 1 and inputed.strip() == "0":
            break
        
        ans = sum(int(c, base=10) for c in inputed)

        print(ans % (2**32 - 1))

if __name__ == "__main__":
    main()