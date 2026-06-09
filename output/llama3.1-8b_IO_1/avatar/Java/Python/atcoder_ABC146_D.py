import random

def generate_random_list():
    return [random.randint(0, 100) for _ in range(100)]

def main():
    # Generate a list of 100 random numbers between 0 and 100
    random_list = generate_random_list()

    # Print the generated list
    print("Generated List:", random_list)

    # Initialize an empty dictionary to store the frequency of each number
    freq_dict = {}

    # Iterate over the list and count the frequency of each number
    for num in random_list:
        if num not in freq_dict:
            freq_dict[num] = 1
        else:
            freq_dict[num] += 1

    # Print the frequency dictionary
    print("Frequency Dictionary:", freq_dict)

    # Initialize an empty list to store the unique numbers and their frequencies
    result = []

    # Iterate over the frequency dictionary and append each number and its frequency to the result list
    for num, freq in freq_dict.items():
        result.append((num, freq))

    # Sort the result list based on the frequency of each number in descending order
    result.sort(key=lambda x: x[1], reverse=True)

    # Print the sorted result list
    print("Sorted Result List:", result)

if __name__ == "__main__":
    main()
