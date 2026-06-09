import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    k = int(input_data[1])
    s = input_data[2]
    
    # Create 26 counters for each letter A-Z
    cards = [0] * 26
    
    # Count each character
    for char in s:
        idx = ord(char) - ord('A')
        cards[idx] += 1
    
    ans = 0
    i = 0
    while i < k:
        cards.sort()
        change = min(cards[25], k - i)
        ans += change * change
        cards[25] -= change
        i += change
    
    print(ans)

if __name__ == "__main__":
    main()
