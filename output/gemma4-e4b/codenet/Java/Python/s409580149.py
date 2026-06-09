import math
from typing import List, Union

# --- Utility Functions (Mimicking the structure of the Java class) ---

def sort_array(arr: List[int]) -> List[int]:
    """Sorts an array of integers."""
    return sorted(arr)

def find_max(arr: List[int]) -> int:
    """Finds the maximum element in an array."""
    if not arr:
        raise ValueError("Cannot find max of an empty array.")
    return max(arr)

def find_min(arr: List[int]) -> int:
    """Finds the minimum element in an array."""
    if not arr:
        raise ValueError("Cannot find min of an empty array.")
    return min(arr)

def sum_array(arr: List[int]) -> int:
    """Calculates the sum of elements in an array."""
    return sum(arr)

def is_sorted(arr: List[int]) -> bool:
    """Checks if an array is sorted in non-decreasing order."""
    return all(arr[i] <= arr[i+1] for i in range(len(arr) - 1))

def reverse_array(arr: List[int]) -> List[int]:
    """Reverses the elements of an array."""
    return arr[::-1]

def get_unique_elements(arr: List[int]) -> List[int]:
    """Returns a list of unique elements from the array, maintaining order (if possible, though set conversion loses order)."""
    # Using dict.fromkeys preserves insertion order in modern Python (3.7+)
    return list(dict.fromkeys(arr))

# --- Math/Number Theory Functions (Mimicking the static methods) ---

def gcd(a: int, b: int) -> int:
    """Calculates the Greatest Common Divisor of two numbers."""
    while b:
        a, b = b, a % b
    return a

def lcm(a: int, b: int) -> int:
    """Calculates the Least Common Multiple of two numbers."""
    if a == 0 or b == 0:
        return 0
    return abs(a * b) // gcd(a, b)

def power(base: Union[int, float], exp: int) -> float:
    """Calculates base raised to the power of exp."""
    return base ** exp

# --- Input/Output Handling (Mimicking the I/O logic) ---

def read_input_line() -> str:
    """Reads a single line of input from standard input."""
    try:
        return input()
    except EOFError:
        return ""

def read_int_list() -> List[int]:
    """Reads a line of space-separated integers from standard input."""
    line = read_input_line()
    if not line:
        return []
    try:
        return [int(x) for x in line.split()]
    except ValueError:
        print("Error: Input must contain only integers.")
        return []

def read_int() -> int:
    """Reads a single integer from standard input."""
    line = read_input_line()
    if not line:
        return 0
    try:
        return int(line)
    except ValueError:
        print("Error: Input must be a single integer.")
        return 0

# --- Example Usage ---

if __name__ == "__main__":
    print("--- Array Utility Examples ---")
    test_array = [5, 1, 8, 3, 8, 1]
    print(f"Original Array: {test_array}")
    
    print(f"Sorted Array: {sort_array(test_array)}")
    print(f"Max Element: {find_max(test_array)}")
    print(f"Min Element: {find_min(test_array)}")
    print(f"Sum: {sum_array(test_array)}")
    print(f"Is Sorted: {is_sorted(test_array)}")
    print(f"Reversed Array: {reverse_array(test_array)}")
    print(f"Unique Elements: {get_unique_elements(test_array)}")

    print("\n--- Math Utility Examples ---")
    a, b = 12, 18
    print(f"GCD({a}, {b}): {gcd(a, b)}")
    print(f"LCM({a}, {b}): {lcm(a, b)}")
    print(f"Power(2, 10): {power(2, 10)}")

    print("\n--- Input Handling Examples (Requires manual input) ---")
    print("Enter space-separated integers (e.g., 1 2 3):")
    input_list = read_int_list()
    print(f"Read List: {input_list}")
    
    print("\nEnter a single integer:")
    input_int = read_int()
    print(f"Read Integer: {input_int}")