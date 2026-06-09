import sys

def main():
    s = sys.stdin.readline().strip()
    k = int(sys.stdin.readline())
    sb = []
    for char in s:
        if char != 'a' and (26 - (ord(char) - ord('a'))) <= k:
            k -= 26 - (ord(char) - ord('a'))
            sb.append('a')
        else:
            sb.append(char)
    
    if k > 0:
        t = sb[-1]
        sb.pop()
        sb.append(chr(ord('a') + (ord(t) - ord('a') + k) % 26))
    
    print(''.join(sb))

if __name__ == "__main__":
    main()
