import sys

def sum_digits(a):
    """Calculates the sum of the digits of a non-negative integer a."""
    if a < 0:
        # Assuming input N >= 1 based on context, but handling defensively.
        a = abs(a)
    
    s = 0
    #
