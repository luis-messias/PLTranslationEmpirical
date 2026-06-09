import sys

def solve():
    # Read all input tokens
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    data_ptr = 0

    def next_int():
        nonlocal data_ptr
        val = int(input_data[data_ptr])
        data_ptr += 1
        return val

    def next_str():
        nonlocal data_ptr
        val = input_data[data_ptr]
        data_ptr += 1
        return val

    try:
        n = next_int()
        m = next_int()
    except IndexError:
        # Handle case where N and M might not be provided
        return

    # penal[i] stores the penalty count for item i
    # solved[i] stores whether item i is solved
    # We use size n+1 to maintain 1-based indexing (indices 1 to n)
    penal = [0] * (n + 1)
    solved = [False] * (n + 1)

    for _ in range(m):
        try:
            num = next_int()
            str_val = next_str()
        except IndexError:
            # Ran out of input data unexpectedly
            break

        if str_val.startswith('A'):
            solved[num] = True
        else:
            if not solved[num]:
                penal[num] += 1

    correct_ans = 0
    num_penal = 0

    for i in range(1, n + 1):
        if solved[i]:
            correct_ans += 1
            num_penal += penal[i]

    print(f"{correct_ans} {num_penal}")

if __name__ == "__main__":
    solve()