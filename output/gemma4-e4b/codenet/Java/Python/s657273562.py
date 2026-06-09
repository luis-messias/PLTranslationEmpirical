import sys
from collections import defaultdict

# Set up input/output handling
# Reading all input at once is often safer in competitive programming environments
def solve():
    # Custom Pair class to handle comparison logic
    class Pair:
        def __init__(self, x, y):
            self.x = x
            self.y = y

        def __eq__(self, other):
            return self.x == other.x and self.y == other.y

        def __hash__(self):
            # Simple hash function
            return hash((self.x, self.y))

        def __lt__(self, other):
            # Mimics the comparison logic for sorting (used for sorting keys)
            # Java's compareTo logic:
            # 1. Compare min(x, y)
            min1 = min(self.x, self.y)
            min2 = min(other.x, other.y)
            if min1 != min2:
                return min1 < min2
            # 2. If min is equal, compare x
            if self.x != other.x:
                return self.x < other.x
            # 3. If x is equal, compare y
            return self.y < other.y

        def __gt__(self, other):
            # Reverse comparison for descending order simulation
            return other < self

        def __le__(self, other):
            return self < other or self == other

        def __ge__(self, other):
            return self > other or self == other

    # Custom comparison function for sorting keys (mimicking Java's compareTo)
    def pair_compare(p1, p2):
        min1 = min(p1.x, p1.y)
        min2 = min(p2.x, p2.y)
        if min1 != min2:
            return min1 - min2
        if p1.x == p2.x:
            return p1.y - p2.y
        return p1.x - p2.x

    # Read input
    try:
        input_data = sys.stdin.read().split()
    except Exception:
        # Handle empty input case
        print(0)
        return

    if not input_data:
        print(0)
        return

    # The first element is N
    try:
        n = int(input_data[0])
    except ValueError:
        # Should not happen if input is well-formed
        print(0)
        return

    # The remaining elements are the array values
    arr = []
    for i in range(1, n + 1):
        try:
            arr.append(int(input_data[i]))
        except IndexError:
            # Handle case where input might be truncated
            break
    
    # Sort the array in descending order (Java: Collections.reverseOrder())
    arr.sort(reverse=True)

    # --- Main Logic Translation ---

    if n < 3:
        if n == 0:
            print(0)
        else:
            # Java prints arr[0] if n < 3
            print(arr[0])
        return

    # map simulates the TreeMap<Pair, Integer>
    # We use a standard dictionary for counts, and manage ordering manually.
    map_counts = defaultdict(int)

    def put(p):
        """Increments count for pair p."""
        map_counts[p] += 1

    def rem(p):
        """Decrements count for pair p, removing if count reaches 0."""
        if map_counts[p] == 1:
            del map_counts[p]
        else:
            map_counts[p] -= 1

    # Initialize the map