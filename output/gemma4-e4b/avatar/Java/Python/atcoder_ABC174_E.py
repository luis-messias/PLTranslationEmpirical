import sys

class InputReader:
    def __init__(self):
        # Read all input lines and process them into tokens
        self.input_data = sys.stdin.read().split()
        self.index = 0

    def next_token(self):
        if self.index >= len(self.input_data):
            raise EOFError("No more input data")
        token = self.input_data[self.index]
        self.index += 1
        return token

    def next_int(self):
        return int(self.next_token())

    def read_array(self, n):
        arr = []
        for _ in range(n):
            arr.append(self.next_int())
        return arr

class Solution:
    def solve(self, in_reader, out_writer):
        try:
            n = in_reader.next_int()
            k = in_reader.next_int()
            logs_length = in_reader.read_array(n)
        except EOFError:
            return

        # Binary search for the minimum 'mid'
        min_val = 1
        # Max value is 10^9 + 1000, matching the Java constant
        max_val = 10**9 + 1000 

        # We are looking for the smallest 'mid' such that nei(mid, logs_length, k) is True
        # The search range is [min_val, max_val]
        
        # Standard binary search template for finding the minimum true value
        result = max_val
        while min_val <= max_val:
            mid = (min_val + max_val) // 2
            
            if self.nei(mid, logs_length, k):
                # mid is possible, try for a smaller answer
                result = mid
                max_val = mid - 1
            else:
                # mid is too small, need a larger answer
                min_val = mid + 1
        
        out_writer.write(str(result) + "\n")

    def nei(self, mid, logs_length, k):
        # Check if the resource k is sufficient for the given mid
        remaining_k = k
        for log in logs_length:
            # Java calculation: k -= ( log + mid - 1 ) / mid - 1
            # This is equivalent to: cost = ceil(log / mid) - 1
            
            # Python integer division for ceiling: (a + b - 1) // b
            cost = ((log + mid - 1) // mid) - 1
            
            remaining_k -= cost
            
        return remaining_k >= 0

def main():
    # Setup input/output handling
    in_reader = InputReader()
    
    # Using sys.stdout.write for efficient output writing
    out_writer = sys.stdout
    
    sol = Solution()
    sol.solve(in_reader, out_writer)

if __name__ == "__main__":
    main()