import sys

def main():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # The first element is N
        N = int(data[0])
        
        if N == 0:
            print("YES")
            return

        # Extract the N elements following N
        if len(data) < N + 1:
            # Input is insufficient
            return

        # Extract the array A
        A = [int(x) for x in data[1:N+1]]
        
        # Check for duplicates by comparing the length of the set to N
        # If len(set(A)) < N, duplicates exist.
        if len(set(A)) < N:
            print("NO")
        else:
            print("YES")

    except ValueError:
        # Handle potential conversion errors
        pass

if __name__ == "__main__":
    main()
