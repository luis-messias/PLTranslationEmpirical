import sys

def solve():
    # Read all input tokens
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # N is the first element
    n = int(input_data[0])
    
    if n <= 1:
        print(0)
        return

    # The remaining elements are 3 * (n - 1) values
    data_index = 1
    
    c = [0] * (n - 1)
    s = [0] * (n - 1)
    f = [0] * (n - 1)

    # Populate the arrays
    for i in range(n - 1):
        c[i] = int(input_data[data_index])
        s[i] = int(input_data[data_index + 1])
        f[i] = int(input_data[data_index + 2])
        data_index += 3

    results = []

    for i in range(n - 1):
        # Initial time calculation
        time = s[i] + c[i]
        
        for j in range(i + 1, n - 1):
            # Step 1: Adjust time to be a multiple of f[j]
            # time % f[j] gives the remainder. 
            # If remainder is 0, time is already a multiple.
            remainder = time % f[j]
            if remainder != 0:
                time += f[j] - remainder

            # Step 2: Ensure time is not before the start time s[j]
            if time < s[j]:
                time = s[j]

            # Step 3: Add duration c[j]
            time += c[j]
        
        results.append(time)

    for result in results:
        print(result)
    
    print(0)

if __name__ == "__main__":
    solve()