def sum_numbers_with_digit_at_position(numbers, digit, position):
    return sum(int(num) for num in numbers.split() if str(digit) == num[position])

numbers = """... (your long list of numbers here)"""
digit = '4'
position = 3

print(sum_numbers_with_digit_at_position(numbers, digit, position))
