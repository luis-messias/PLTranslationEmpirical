import math

class Utility:
    """
    A utility class mirroring the functionality of the provided Java class,
    handling various mathematical and list operations.
    """

    @staticmethod
    def max_of_three(a: float, b: float, c: float) -> float:
        """Returns the maximum of three given numbers."""
        return max(a, b, c)

    @staticmethod
    def min_of_three(a: float, b: float, c: float) -> float:
        """Returns the minimum of three given numbers."""
        return min(a, b, c)

    @staticmethod
    def calculate_gcd(a: int, b: int) -> int:
        """Calculates the Greatest Common Divisor (GCD) of two integers using the Euclidean algorithm."""
        while b:
            a, b = b, a % b
        return a

    @staticmethod
    def calculate_lcm(a: int, b: int) -> int:
        """Calculates the Least Common Multiple (LCM) of two integers."""
        if a == 0 or b == 0:
            return 0
        return abs(a * b) // Utility.calculate_gcd(a, b)

    @staticmethod
    def is_prime(n: int) -> bool:
        """Checks if a given integer n is a prime number."""
        if n <= 1:
            return False
        if n <= 3:
            return True
        if n % 2 == 0 or n % 3 == 0:
            return False
        i = 5
        while i * i <= n:
            if n % i == 0 or n % (i + 2) == 0:
                return False
            i += 6
        return True

    @staticmethod
    def is_perfect_square(n: int) -> bool:
        """Checks if a given integer n is a perfect square."""
        if n < 0:
            return False
        if n == 0:
            return True
        root = int(math.isqrt(n))
        return root * root == n

    @staticmethod
    def reverse_string(s: str) -> str:
        """Reverses a given string."""
        return s[::-1]

    @staticmethod
    def is_palindrome(s: str) -> bool:
        """Checks if a given string is a palindrome (case-insensitive, ignoring non-alphanumeric)."""
        processed_s = "".join(filter(str.isalnum, s)).lower()
        return processed_s == processed_s[::-1]

    @staticmethod
    def calculate_factorial(n: int) -> int:
        """Calculates the factorial of a non-negative integer n."""
        if n < 0:
            raise ValueError("Factorial is not defined for negative numbers.")
        if n == 0:
            return 1
        result = 1
        for i in range(1, n + 1):
            result *= i
        return result

    @staticmethod
    def is_leap_year(year: int) -> bool:
        """Checks if a given year is a leap year."""
        return (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0)

    @staticmethod
    def calculate_days_between(start_year: int, start_month: int, start_day: int, end_year: int, end_month: int, end_day: int) -> int:
        """
        Calculates the number of days between two dates.
        Note: This is a simplified implementation and might not handle all edge cases
        of date arithmetic perfectly without using the datetime module.
        For this exercise, we assume the inputs are valid dates.
        """
        from datetime import date
        try:
            start_date = date(start_year, start_month, start_day)
            end_date = date(end_year, end_month, end_day)
            return (end_date - start_date).days
        except ValueError as e:
            print(f"Error calculating days: {e}")
            return -1

# Example Usage (Demonstration)
if __name__ == '__main__':
    print("--- Math Utilities ---")
    print(f"Max of (10, 5, 20): {Utility.max_of_three(10, 5, 20)}")
    print(f"Min of (10, 5, 20): {Utility.min_of_three(10, 5, 20)}")

    print("\n--- Number Theory ---")
    print(f"GCD(54, 24): {Utility.calculate_gcd(54, 24)}")
    print(f"LCM(12, 18): {Utility.calculate_lcm(12, 18)}")
    print(f"Is 17 prime? {Utility.is_prime(17)}")
    print(f"Is 15 prime? {Utility.is_prime(15)}")
    print(f"Is 25 a perfect square? {Utility.is_perfect_square(25)}")
    print(f"Is 26 a perfect square? {Utility.is_perfect_square(26)}")

    print("\n--- String Utilities ---")
    print(f"Reverse 'hello': {Utility.reverse_string('hello')}")
    print(f"Is 'racecar' a palindrome? {Utility.is_palindrome('racecar')}")
    print(f"Is 'A man, a plan, a canal: Panama' a palindrome? {Utility.is_palindrome('A man, a plan, a canal: Panama')}")

    print("\n--- Factorial & Calendar ---")
    print(f"Factorial of 5: {Utility.calculate_factorial(5)}")
    print(f"Is 2024 a leap year? {Utility.is_leap_year(2024)}")
    print(f"Is 2023 a leap year? {Utility.is_leap_year(2023)}")

    print("\n--- Date Calculation ---")
    # Date calculation: From Jan 1, 2023 to Jan 1, 2025 (Should be 731 days)
    days = Utility.calculate_days_between(2023, 1, 1, 2025, 1, 1)
    print(f"Days between 2023-01-01 and 2025-01-01: {days} days")
