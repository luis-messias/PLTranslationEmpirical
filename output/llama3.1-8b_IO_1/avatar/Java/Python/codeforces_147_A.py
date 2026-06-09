import sys

def is_latin_letter(c):
    return 'a' <= c <= 'z'

def is_punctuation(c):
    return c in ['.', ',', '!', '?']

def main():
    s = input().replace("  ", " ")
    sb = [s[0]]
    for i in range(1, len(s)):
        c = s[i]
        if is_latin_letter(c) and not is_latin_letter(sb[-1]):
            sb.append(' ')
        sb.append(c)
    print(''.join(sb))

if __name__ == "__main__":
    main()
