import sys

def solve():
    # Read all input tokens
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # N is the first element
    try:
        N = int(input_data[0])
    except ValueError:
        return

    # The next N elements are the strings
    if len(input_data) < N + 1:
        return

    str_list = input_data[1:N+1]

    # Build the grid (list of lists of characters)
    arr = []
    for s in str_list:
        arr.append(list(s))

    # Check the condition
    a = arr[0][0]
    b = arr[0][1]

    if a == b:
        print("NO")
    else:
        res = True
        for i in range(N):
            for j in range(N):
                # Diagonal or anti-diagonal check
                if i == j or i + j == N - 1:
                    if arr[i][j] != a:
                        res = False
                        break
                # Other positions
                else:
                    if arr[i][j] != b:
                        res = False
                        break
            
            if not res:
                break

        if res:
            print("YES")
        else:
            print("NO")

solve()