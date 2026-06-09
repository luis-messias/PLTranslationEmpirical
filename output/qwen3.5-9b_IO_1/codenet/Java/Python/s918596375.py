import sys

def main():
    s = sys.stdin.read().strip()
    vowels = {'a', 'e', 'i', 'o', 'u'}
    
    if s.lower() in vowels:
        print("vowel")
    else:
        print("consonant")

if __name__ == "__main__":
    main()
