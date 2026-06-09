import sys

def solve():
    # Read all input lines to simulate sequential scanner reading
    input_data = sys.stdin.read().splitlines()
    line_index = 0
    result = []

    while line_index < len(input_data):
        try:
            # 1. Read N
            line_n = input_data[line_index].strip()
            line_index += 1
            
            if not line_n:
                continue
            
            n = int(line_n)
            
            if n == 0:
                break
            
            # 2. Read the array line
            if line_index >= len(input_data):
                break
            
            line_array = input_data[line_index].strip()
            line_index += 1
            
            # 3. Process the array
            if not line_array:
                break

            array2 = line_array.split()
            
            # Convert strings to integers
            input_list = [int(x) for x in array2]

            # Calculate sum and average
            total_sum = sum(input_list)
            avg = total_sum / n

            # Count elements <= avg
            num = 0
            for x in input_list:
                if x <= avg:
                    num += 1
            
            result.append(num)

        except ValueError:
            # Stop if input format is incorrect
            break
        except IndexError:
            # Stop if input runs out unexpectedly
            break

    # Output results
    for res in result:
        # The Java code checks for -1, but since 'num' is a count, it should be >= 0.
        # We print the calculated count directly.
        print(res)

solve()
