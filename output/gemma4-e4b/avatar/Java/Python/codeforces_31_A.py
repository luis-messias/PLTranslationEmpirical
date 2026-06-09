import sys

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    if not data:
        return

    try:
        N = int(data[0])
        A = [int(x) for x in data[1:N+1]]
    except IndexError:
        # Handle case where input might be incomplete
        return

    f = 0
    k = 0
    j = 0
    i = 0

    # k loop
    for k in range(N):
        t = A[k]
        
        # i loop
        for i in range(N):
            # j loop
            for j in range(N - 1):
                if i != j and t == (A[i] + A[j]):
                    f = 1
                    break  # Break j loop
            
            if f == 1:
                break  # Break i loop
        
        if f == 1:
            break  # Break k loop

    # Output logic
    if f == 1:
        # Output k+1, j+1, i+1
        print(f"{k + 1} {j + 1} {i + 1}")
    else:
        print("-1")

solve()