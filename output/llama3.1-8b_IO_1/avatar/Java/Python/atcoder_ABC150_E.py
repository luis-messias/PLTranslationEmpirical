def sum_of_numbers():
    # Given list of numbers
    numbers = [int(num) for num in str([int(num) for num in open('input.txt').read().split()])[1:-1].split(',')]

    # Calculate the sum of all numbers
    total_sum = sum(numbers)

    return total_sum

# Print the result
print(sum_of_numbers())
