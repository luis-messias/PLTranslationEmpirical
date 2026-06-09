def calculate_sum(n):
    """Calculates the sum of integers from 1 to n."""
    return n * (n + 1) // 2

# The problem asks for the sum of integers from 1 to 100.
n = 100
result = calculate_sum(n)
print(result)
