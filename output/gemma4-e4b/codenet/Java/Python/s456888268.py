import math
from typing import List, Union

class Utility:
    """
    A collection of static utility methods mirroring the functionality 
    of the original Java class, handling array operations, math, and I/O helpers.
    """

    # --- Array/List Manipulation Helpers ---

    @staticmethod
    def sort_list(arr: List[Union[int, float]]) -> List[Union[int, float]]:
        """Sorts a list of numbers."""
        return sorted(arr)

    @staticmethod
    def unique_elements(arr: List[Union[int, float]]) -> List[Union[int, float]]:
        """Returns a list containing only unique elements from the input list."""
        return list(set(arr))

    @staticmethod
    def reverse_list(arr: List[Union[int, float]]) -> List[Union[int, float]]:
        """Returns a reversed copy of the input list."""
        return arr[::-1]

    @staticmethod
    def get_sum(arr: List[Union[int, float]]) -> Union[int, float]:
        """Calculates the sum of all elements in the list."""
        return sum(arr)

    @staticmethod
    def get_product(arr: List[Union[int, float]]) -> Union[int, float]:
        """Calculates the product of all elements in the list."""
        if not arr:
            return 1
        product = 1
        for x in arr:
            product *= x
        return product

    # --- Math Helpers ---

    @staticmethod
    def max_of_three(a: Union[int, float], b: Union[int, float], c: Union[int, float]) -> Union[int, float]:
        """Returns the maximum of three given numbers."""
        return max(a, b, c)

    @staticmethod
    def min_of_three(a: Union[int, float], b: Union[int, float], c: Union[int, float]) -> Union[int, float]:
        """Returns the minimum of three given numbers."""
        return min(a, b, c)

    # --- Input/Output Helpers (Mimicking Java's Scanner/Reader) ---

    @staticmethod
    def read_int() -> int:
        """Reads a single integer from standard input."""
        try:
            return int(input())
        except EOFError:
            raise EOFError("End of input reached.")
        except ValueError:
            raise ValueError("Input must be a valid integer.")

    @staticmethod
    def read_float() -> float:
        """Reads a single float from standard input."""
        try:
            return float(input())
        except EOFError:
            raise EOFError("End of input reached.")
        except ValueError:
            raise ValueError("Input must be a valid float.")

    @staticmethod
    def read_list_of_ints(count: int) -> List[int]:
        """Reads a line of space-separated integers."""
        try:
            line = input()
            return [int(x) for x in line.split()]
        except EOFError:
            raise EOFError("End of input reached.")
        except ValueError:
            raise ValueError("Input must be space-separated integers.")

    @staticmethod
    def read_list_of_floats(count: int) -> List[float]:
        """Reads a line of space-separated floats."""
        try:
            line = input()
            return [float(x) for x in line.split()]
        except EOFError:
            raise EOFError("End of input reached.")
        except ValueError:
            raise ValueError("Input must be space-separated floats.")

# --- Example Usage ---
if __name__ == "__main__":
    print("--- Testing Utility Class ---")

    # 1. List Manipulation Test
    test_list = [1, 5, 2, 5, 1]
    print(f"\nOriginal List: {test_list}")
    print(f"Sorted List: {Utility.sort_list(test_list)}")
    print(f"Unique Elements: {Utility.unique_elements(test_list)}")
    print(f"Reversed List: {Utility.reverse_list(test_list)}")
    print(f"Sum: {Utility.get_sum(test_list)}")
    print(f"Product: {Utility.get_product(test_list)}")

    # 2. Math Test
    print(f"\nMax of (10, 20, 5): {Utility.max_of_three(10, 20, 5)}")
    print(f"Min of (10, 20, 5): {Utility.min_of_three(10, 20, 5)}")

    # 3. I/O Test (Requires manual input or redirection for full testing)
    print("\n--- I/O Test Instructions ---")
    print("To test I/O, run this script and provide input when prompted.")
    
    try:
        # Example: Reading a single integer
        # print("Enter an integer:")
        # num = Utility.read_int()
        # print(f"Read Integer: {num}")

        # Example: Reading a list of floats
        # print("Enter space-separated floats (e.g., 1.1 2.2 3.3):")
        # float_list = Utility.read_list_of_floats(3)
        # print(f"Read Float List: {float_list}")

    except (EOFError, ValueError) as e:
        print(f"I/O Test Skipped or Failed: {e}")