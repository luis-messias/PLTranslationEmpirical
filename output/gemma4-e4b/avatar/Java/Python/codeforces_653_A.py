import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    
    if not data:
        print("NO")
        return

    try:
        # The first element is N
        N = int(data[0])
        # The remaining N elements are the list values
        if N > 0:
            A_list = [int(x) for x in data[1:N+1]]
        else:
            A_list = []
    except IndexError:
        # Handle case where input might be incomplete
        print("NO")
        return

    # Get unique and sorted elements
    A = sorted(list(set(A_list)))

    # Check for three consecutive numbers
    found = False
    if len(A) >= 3:
        for i in range(len(A) - 2):
            # Check if A[i], A[i+1], A[i+2] form a sequence x, x+1, x+2
            if A[i] + 1 == A[i+1] and A[i+1] + 1 == A[i+2]:
                found = True
                break

    print("YES" if found else "NO")

if __name__ == "__main__":
    solve()