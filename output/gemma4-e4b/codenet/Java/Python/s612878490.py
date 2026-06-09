import sys

def solve():
    # Read all input lines
    input_data = sys.stdin.read().splitlines()
    
    if not input_data:
        return

    # 1. Read N and M from the first line
    try:
        N, M = map(int, input_data[0].split())
    except ValueError:
        return

    shortage = []
    
    # 2. Read M subsequent lines for A
    # These lines are at indices 1 through M
    for i in range(M):
        line_index = i + 1
        if line_index >= len(input_data):
            break
        
        try:
            A = int(input_data[line_index].strip())
        except ValueError:
            continue
            
        # Calculate shortage: max(0, N - A)
        shortage.append(max(0, N - A))

    # 3. Sort the shortages
    shortage.sort()

    # 4. Calculate the sum of the first M-1 elements
    # We sum the slice up to index M-1 (exclusive of the last element)
    if M > 0:
        ans = sum(shortage[:M-1])
    else:
        ans = 0
        
    print(ans)

if __name__ == "__main__":
    solve()