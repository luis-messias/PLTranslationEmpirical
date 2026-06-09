import sys

def solve():
    # Read all inputs from standard input
    data = sys.stdin.read().split()
    if not data:
        return

    try:
        H = int(data[0])
        W = int(data[1])
        A = int(data[2])
        B = int(data[3])
    except IndexError:
        # Handle insufficient input if necessary
        return

    if W < 2 * A or H < 2 * B:
        print(-1)
        return

    output_lines = []
    for i in range(H):
        row = []
        for j in range(W):
            # Condition: (i < B and j < A) or (i >= B and j >= A)
            if (i < B and j < A) or (i >= B and j >= A):
                row.append("0")
            else:
                row.append("1")
        output_lines.append("".join(row))

    print('\n'.join(output_lines))

if __name__ == "__main__":
    solve()