import sys

def solve():
    # Read all input tokens from standard input
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # The first element is N
        n = int(data[0])
    except ValueError:
        return

    # The remaining elements are the array A
    if len(data) < n + 1:
        return

    a = [int(x) for x in data[1:n+1]]

    # Sort the array
    a.sort()

    # Check the condition
    found = False
    for i in range(len(a) - 1):
        # Check if a[i+1] < a[i] * 2 AND a[i] != a[i+1]
        if a[i+1] < a[i] * 2 and a[i] != a[i+1]:
            print("YES")
            found = True
            break
    
    if not found:
        print("NO")

if __name__ == "__main__":
    solve()