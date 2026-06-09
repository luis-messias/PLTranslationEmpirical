import sys

n = int(input())
l = list(map(int, input().split()))
print(sorted(l)[len(l)//2] - sorted(l)[(len(l)-1)//2])

if __name__ == "__main__":
    from math import gcd as compute_gcd  # For the GCD function (not used in this code but kept for context)

# The rest of the original Java class and methods are not translated since they have no direct use here.