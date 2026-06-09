import sys
from collections import Counter

def main():
    # Read all input tokens
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # The first element is N
    try:
        n = int(input_data[0])
    except ValueError:
        return

    # The remaining elements are the array 'ara'
    if n == 0:
        return
        
    ara = [int(x) for x in input_data[1:n+1]]

    # 1. Frequency Counting (Java 'map')
    counts = Counter(ara)

    # 2. Finding Max Frequency (Java 'max')
    if not counts:
        return
    max_freq = max(counts.values())

    # 3. Finding the first element that reaches max frequency (Java 'mm' loop)
    current_counts = {}
    result = None
    
    for element in ara:
        # Update count for the current element
        current_counts[element] = current_counts.get(element, 0) + 1
        
        # Check if this count reaches max_freq
        if current_counts[element] == max_freq:
            result = element
            break
            
    # Output the result
    if result is not None:
        print(result)

main()
