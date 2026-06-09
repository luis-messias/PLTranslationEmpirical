import sys
import collections

def solve():
    # Read all input tokens from standard input
    input_tokens = sys.stdin.read().split()
    if not input_tokens:
        return

    # Use an iterator to consume tokens sequentially
    data_iter = iter(input_tokens)

    try:
        # Read N and K
        n = int(next(data_iter))
        k = int(next(data_iter))
    except StopIteration:
        return

    # map: person_id -> list_of_d_values
    map_data = collections.defaultdict(list)

    # Process K blocks
    for _ in range(k):
        try:
            # Read D
            d = int(next(data_iter))
        except StopIteration:
            break

        # Process d people
        for _ in range(d):
            try:
                person = int(next(data_iter))
            except StopIteration:
                break
            
            # Update the map
            map_data[person].append(d)

    # Count people from 1 to N that are not in the map keys
    count = 0
    for i in range(1, n + 1):
        if i not in map_data:
            count += 1

    print(count)

if __name__ == "__main__":
    solve()