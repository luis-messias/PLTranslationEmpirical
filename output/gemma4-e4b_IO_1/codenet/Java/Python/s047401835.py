import sys

def solve():
    # Read all input tokens from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    try:
        N = int(input_data[0])
        # The numbers start from the second token up to N elements
        numbers = [int(x) for x in input_data[1:N+1]]
    except IndexError:
        # Handle case where input might be incomplete
        return

    count = 0

    # The loop structure mimics Java's do-while loop
    while True:
        # Filter even numbers and map i -> i / 2 (integer division)
        new_numbers = []
        for x in numbers:
            if x % 2 == 0:
                new_numbers.append(x // 2)
        
        numbers = new_numbers
        
        # Check the loop termination condition
        if len(numbers) != N:
            break
        
        # If the size matches N, increment count
        count += 1

    print(count)

solve()
