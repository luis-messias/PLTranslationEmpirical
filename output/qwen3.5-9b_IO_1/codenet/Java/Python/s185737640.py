import sys

def is_even_string(s):
    mid = len(s) // 2
    a = s[:mid]
    b = s[mid:]
    return a == b

def main():
    S = sys.stdin.readline().strip()
    
    if len(S) % 2 == 1:
        S = S[:-1]
    else:
        S = S[:-2]
    
    while len(S) > 0 and not is_even_string(S):
        S = S[:-2]
    
    print(len(S))

if __name__ == "__main__":
    main()
