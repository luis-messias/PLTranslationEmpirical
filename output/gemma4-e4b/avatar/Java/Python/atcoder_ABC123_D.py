import sys

def solve():
    # Read all input tokens
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    data_ptr = 0

    # 1. Read x (x[0], x[1], x[2])
    x = [int(input_data[data_ptr + i]) for i in range(3)]
    data_ptr += 3

    # 2. Read k
    k = int(input_data[data_ptr])
    data_ptr += 1

    # 3. Initialize lists a[0], a[1], a[2]
    a = [[] for _ in range(3)]
    
    # 4. Read the elements for a[0], a[1], a[2]
    current_ptr = data_ptr
    for i in range(3):
        count = x[i]
        for _ in range(count):
            # Elements are read as long integers, so we use int() which handles large numbers in Python
            a[i].append(int(input_data[current_ptr]))
            current_ptr += 1
    
    # 5. Sort the lists
    # The Java code uses Collections.sort, which sorts in ascending order.
    for i in range(3):
        a[i].sort()

    ans = []

    # 6. Triple loop iteration
    for i in range(x[0]):
        for j in range(x[1]):
            for m in range(x[2]):
                # Check condition: (i + 1) * (j + 1) * (m + 1) <= k
                if (i + 1) * (j + 1) * (m + 1) <= k:
                    # Calculate sum using indices relative to the end (largest elements)
                    # Index for a[0]: x[0] - i - 1
                    # Index for a[1]: x[1] - j - 1
                    # Index for a[2]: x[2] - m - 1
                    
                    # Since lists are 0-indexed and sorted ascendingly, 
                    # accessing index N-1 gives the largest element.
                    
                    val0 = a[0][x[0] - i - 1]
                    val1 = a[1][x[1] - j - 1]
                    val2 = a[2][x[2] - m - 1]
                    
                    tmp = val0 + val1 + val2
                    ans.append(tmp)

    # 7. Sort ans
    ans.sort()

    # 8. Output the top k largest elements
    n = len(ans)
    
    # We need to print the last min(k, n) elements.
    count_to_print = min(k, n)
    
    # Print the elements in descending order (largest first)
    for i in range(count_to_print):
        # The largest element is at index n - 1. The i-th largest is at index n - 1 - i.
        print(ans[n - 1 - i])

solve()