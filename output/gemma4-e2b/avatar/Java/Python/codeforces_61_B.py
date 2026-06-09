import sys

def clean_word(word):
    # Removes non-alphabetic characters and converts to lowercase
    return "".join(filter(str.isalpha, word)).lower()

# Read word1, word2, word3
word1 = input()
word2 = input()
word3 = input()

# Clean and store the base words
word1 = clean_word(word1)
word2 = clean_word(word2)
word3 = clean_word(word3)

# Calculate permutations
perm1 = word1 + word2 + word3
perm2 = word1 + word3 + word2
perm3 = word2 + word1 + word3
perm4 = word2 + word3 + word1
perm5 = word3 + word2 + word1
perm6 = word3 + word1 + word2

# Read students
students = int(input())

# Read and check test cases
for _ in range(students):
    testCase = input()
    testCase_cleaned = clean_word(testCase)
    
    if testCase_cleaned in [perm1, perm2, perm3, perm4, perm5, perm6]:
        print("ACC")
    else:
        print("WA")