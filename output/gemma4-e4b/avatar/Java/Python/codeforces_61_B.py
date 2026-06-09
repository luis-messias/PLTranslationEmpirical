import re
import sys

def clean_word(s):
    """Removes non-alphabetic characters and converts to lowercase."""
    return re.sub(r'[^a-zA-Z]', '', s).lower()

def solve():
    # Read the three words
    try:
        word1_raw = sys.stdin.readline().strip()
        word2_raw = sys.stdin.readline().strip()
        word3_raw = sys.stdin.readline().strip()
    except EOFError:
        return

    word1 = clean_word(word1_raw)
    word2 = clean_word(word2_raw)
    word3 = clean_word(word3_raw)

    # Generate all 6 permutations
    perms = set()
    perms.add(word1 + word2 + word3)
    perms.add(word1 + word3 + word2)
    perms.add(word2 + word1 + word3)
    perms.add(word2 + word3 + word1)
    perms.add(word3 + word2 + word1)
    perms.add(word3 + word1 + word2)

    # Read the number of students (test cases)
    try:
        students_line = sys.stdin.readline().strip()
        if not students_line:
            return
        students = int(students_line)
    except ValueError:
        return

    # Process test cases
    for _ in range(students):
        try:
            test_case_raw = sys.stdin.readline().strip()
            if not test_case_raw:
                break
            
            test_case = clean_word(test_case_raw)
            
            if test_case in perms:
                print("ACC")
            else:
                print("WA")
        except EOFError:
            break

solve()