from collections import Counter

def count_frequencies(file_name):
    with open(file_name, 'r') as f:
        numbers = [int(line.strip()) for line in f.readlines()]
    
    frequencies = Counter(numbers)
    
    return frequencies

file_name = 'input.txt'  # replace with your file name
frequencies = count_frequencies(file_name)

for num, freq in frequencies.items():
    print(f'{num}: {freq}')
