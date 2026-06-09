c = input()
letter = ord(c[0]) + 1

if not (97 <= letter and letter < 123):
    raise ValueError("Input must be a lowercase or uppercase character between 'a' and 'z' for letters, otherwise it will wrap around to the next character in the range of characters.")

print(chr(letter))