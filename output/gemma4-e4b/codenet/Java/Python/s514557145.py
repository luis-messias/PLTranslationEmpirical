import math

# --- Range Class Translation ---
# This class seems designed to store aggregated information over a range,
# and the 'merge' operation combines information from two adjacent ranges.

class Range:
    """
    Represents aggregated data over a specific range.
    The structure suggests properties like sum, min, max, etc., are stored.
    """
    def __init__(self, length=0, sum_val=0, min_val=float('inf'), max_val=float('-inf')):
        self.length = length
        self.sum_val = sum_val
        self.min_val = min_val
        self.max_val = max_val

    @staticmethod
    def identity():
        """Returns an identity element for merging (e.g., for an empty range)."""
        return Range(length=0, sum_val=0, min_val=float('inf'), max_val=float('-inf'))

    @staticmethod
    def merge(left_range: 'Range', right_range: 'Range') -> 'Range':
        """
        Merges two adjacent ranges (left and right) into a new range.
        This is the core logic of the segment tree node combination.
        """
        if left_range.length == 0:
            return right_range
        if right_range.length == 0:
            return left_range

        new_length = left_range.length + right_range.length
        new_sum = left_range.sum_val + right_range.sum_val
        
        # The new minimum is the minimum of the two ranges' minimums
        new_min = min(left_range.min_val, right_range.min_val)
        
        # The new maximum is the maximum of the two ranges' maximums
        new_max = max(left_range.max_val, right_range.max_val)
        
        return Range(
            length=new_length, 
            sum_val=new_sum, 
            min_val=new_min, 
            max_val=new_max
        )

    def __repr__(self):
        return (f"Range(len={self.length}, sum={self.sum_val}, "
                f"min={self.min_val}, max={self.max_val})")

# --- Input Reader Utility (Conceptual Translation) ---
# Since the original code snippet didn't show the full InputReader, 
# I'll provide a standard Python implementation for reading inputs, 
# which is usually the context for such classes.

class InputReader:
    """
    A utility class to handle fast input reading, common in competitive programming.
    """
    def __init__(self):
        # In a real scenario, this would read all input lines or set up file pointers.
        pass

    def read_int(self):
        # Placeholder for reading a single integer
        # return int(input()) 
        pass

    def read_ints(self, count):
        # Placeholder for reading a list of integers
        # return list(map(int, input().split()))
        pass

# --- Example Usage (Demonstration) ---

if __name__ == "__main__":
    print("--- Testing Range Merging ---")
    
    # 1. Create two sample ranges
    # Range 1: Represents [1, 2, 3]
    r1 = Range(length=3, sum_val=6, min_val=1, max_val=3)
    print(f"R1 (Initial): {r1}")

    # Range 2: Represents [4, 5]
    r2 = Range(length=2, sum_val=9, min_val=4, max_val=5)
    print(f"R2 (Initial): {r2}")

    # 2. Merge them
    merged_range = Range.merge(r1, r2)
    print("\n--- Merging R1 and R2 ---")
    print(f"Merged Range: {merged_range}")
    # Expected: Length=5, Sum=15, Min=1, Max=5

    # 3. Test with identity element (empty range)
    empty_range = Range.identity()
    
    # Merge R1 with empty
    merged_empty_right = Range.merge(r1, empty_range)
    print("\n--- Merging R1 with Empty Right ---")
    print(f"Result: {merged_empty_right}")
    
    # Merge empty with R2
    merged_empty_left = Range.merge(empty_range, r2)
    print("\n--- Merging Empty Left with R2 ---")
    print(f"Result: {merged_empty_left}")