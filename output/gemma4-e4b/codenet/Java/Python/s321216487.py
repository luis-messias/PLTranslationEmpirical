import sys

def main():
    # Read the single token input, mimicking Scanner.next()
    try:
        # Read all input and strip whitespace, assuming a single word input
        S = sys.stdin.read().strip()
    except Exception:
        S = ""

    N = len(S)

    # i iterates through potential prefix lengths (0 to N-1)
    for i in range(N):
        # j iterates through potential suffix start indices (0 to N-1)
        for j in range(N):
            
            # begin = S.substring(0, i)
            begin = S[:i]
            
            # end = S.substring(j, S.length())
            end = S[j:]
            
            answer = begin + end
            
            if answer == "keyence":
                print("YES")
                return
            
            if begin == "keyence":
                print("YES")
                return
            
            if end == "keyence":
                print("YES")
                return

    print("NO")

if __name__ == "__main__":
    main()