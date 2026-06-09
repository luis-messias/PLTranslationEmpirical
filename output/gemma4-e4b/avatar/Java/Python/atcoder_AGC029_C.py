import sys
from collections import defaultdict

class atcoder_AGC029_C:
    def __init__(self):
        self.n = 0
        self.a = []
        # Using a dictionary to simulate TreeMap behavior for counts of slots.
        # Keys are slot indices (p), values are counts (sp).
        self.s = defaultdict(int)

    def set(self):
        # Read N
        try:
            input_data = sys.stdin.read().split()
            if not input_data:
                return
            
            self.n = int(input_data[0])
            
            # Read array A
            self.a = [int(x) for x in input_data[1:]]
        except Exception as e:
            # Handle EOF or bad input gracefully if necessary
            pass

    def solve(self):
        self.set()
        
        if self.n == 0:
            # Handle case where input reading failed or N=0
            return

        # Binary search setup
        ng = 0  # low bound
        ok = self.n # high bound (The maximum possible answer is N)

        # The problem structure suggests finding the maximum k such that isPossible(k) is true.
        # Since isPossible(k) is monotonic (if k works, k-1 might work, but if k doesn't work, k+1 won't),
        # we search for the transition point.
        
        # We are looking for the largest k such that isPossible(k) is True.
        # The search range is [0, N].
        
        # Adjusting the binary search logic based on the Java implementation:
        # Java: while (ok - ng > 1) { k = (ng + ok) / 2; if (isPossible(k)) { ok = k; } else { ng = k; } }
        # This finds the smallest 'ok' such that isPossible(ok) is True, assuming the search space is [0, N].
        # Wait, the problem asks for the maximum k. Let's assume the standard binary search pattern for finding the maximum valid value.
        
        # Let's stick strictly to the Java logic:
        # If isPossible(k) is True, it means k is a potential answer, so we try smaller (ok = k).
        # If isPossible(k) is False, k is too small, so we must increase (ng = k).
        
        # This structure finds the minimum k such that isPossible(k) is True, if the property is monotonic (False, False, ..., True, True, ...).
        # If the goal is to find the maximum k, the logic