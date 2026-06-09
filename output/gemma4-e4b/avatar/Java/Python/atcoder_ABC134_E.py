import sys
import bisect

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    try:
        N = int(data[0])
    except ValueError:
        # Handle case where N might not be an integer
        return

    # The remaining elements are the sequence of numbers
    nums = [int(x) for x in data[1:]]

    # map simulates the TreeMap: key -> count
    # We use a standard dict, but rely on sorted keys for lowerKey simulation.
    data_map = {}

    def get_lower_key(current_map, num):
        """Simulates TreeMap.lowerKey(num): finds the largest key < num."""
        if not current_map:
            return None
        
        # Get sorted keys
        sorted_keys = sorted(current_map.keys())
        
        # Find the insertion point for 'num'
        # bisect_left returns the index where 'num' would be inserted 
        # while maintaining sorted order.
        idx = bisect.bisect_left(sorted_keys, num)
        
        if idx == 0:
            # All keys are >= num
            return None
        else:
            # The element at idx