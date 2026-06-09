def find_sum():
    numbers = """... (your input string here)"""
    
    # Remove all non-digit characters and convert to a list of integers
    digits = [int(digit) for digit in ''.join(filter(str.isdigit, numbers))]
    
    # Reverse the list
    digits.reverse()
    
    # Convert the list back into an integer
    result = int(''.join(map(str, digits)))
    
    return result

print(find_sum())
