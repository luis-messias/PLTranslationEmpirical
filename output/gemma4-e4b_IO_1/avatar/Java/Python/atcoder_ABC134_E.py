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
        return

    # The remaining elements are the sequence of numbers
    nums = [int(x) for x in data[1:]]

    # data_map simulates the TreeMap: key -> count
    data_map = {}

    def get_lower_key(current_map, num):
        """Simulates TreeMap.lowerKey(num): finds the largest key < num."""
        if not current_map:
            return None
        
        # Get sorted keys
        sorted_keys = sorted(current_map.keys())
        
        # Find the index where 'num' would be inserted
        # bisect_left returns the index of the first element >= num.
        idx = bisect.bisect_left(sorted_keys, num)
        
        if idx == 0:
            # All keys are >= num
            return None
        else:
            # The element at idx - 1 is the largest key < num
            return sorted_keys[idx - 1]

    for num in nums:
        # 1. Check for lower key
        key = get_lower_key(data_map, num)
        
        if key is None:
            # Case 1: No lower key (map.lowerKey(num) == null)
            # val = map.getOrDefault(num, 0)
            val = data_map.get(num, 0)
            # map.put(num, ++val)
            data_map[num] = val + 1
        else:
            # Case 2: Lower key exists
            
            # Get value of the lower key
            val = data_map[key]
            
            # If val == 1: map.remove(key)
            if val == 1:
                del data_map[key]
            # Else: map.put(key, --val)
            else:
                data_map[key] = val - 1
                
            # Update count for num
            # val = map.getOrDefault(num, 0)
            val = data_map.get(num, 0)
            # map.put(num, ++val)
            data_map[num] = val + 1

    # Calculate the sum of all values in the map
    ans = sum(data_map.values())
    print(ans)

solve()
