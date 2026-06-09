def solve():
    try:
        # Read the input string (assuming it's the first token/word)
        s = input()
    except EOFError:
        return

    # The logic checks if any two characters are the same:
    # s[0] == s[1] OR s[1] == s[2] OR s[2] == s[0]
    if s[0] == s[1] or s[1] == s[2] or s[2] == s[0]:
        print("No")
    else:
        print("Yes")

if __name__ == "__main__":
    solve()