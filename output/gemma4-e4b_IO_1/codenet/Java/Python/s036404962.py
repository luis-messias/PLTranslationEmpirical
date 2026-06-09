import sys

def main():
    # Read all input from stdin and split by whitespace
    try:
        data = sys.stdin.read().split()
        if len(data) < 2:
            return
        
        X = int(data[0])
        t = int(data[1])
    except Exception:
        return

    if X >= t:
        print(X - t)
    else:
        print(0)

if __name__ == "__main__":
    main()
