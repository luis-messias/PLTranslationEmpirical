import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first two tokens are n and m
    try:
        n = int(data[0])
        m = int(data[1])
    except IndexError:
        return
    except ValueError:
        return

    # Initialize arrays (using 1-based indexing conceptually, so size n+1)
    penal = [0] * (n + 1)
    solved = [False] * (n + 1)

    data_index = 2
    
    # Process m operations
    for _ in range(m):
        if data_index + 1 >= len(data):
            break
            
        try:
            num = int(data[data_index])
            str_val = data[data_index + 1]
            data_index += 2
        except ValueError:
            # Handle case where input might be malformed
            continue

        if num > 0 and num <= n:
            if str_val[0] == 'A':
                solved[num] = True
            else:
                if not solved[num]:
                    penal[num] += 1

    # Calculate results
    correct_ans = 0
    num_penal = 0
    
    for i in range(1, n + 1):
        if solved[i]:
            correct_ans += 1
            num_penal += penal[i]

    # Output the result
    print(f"{correct_ans} {num_penal}")

if __name__ == "__main__":
    solve()