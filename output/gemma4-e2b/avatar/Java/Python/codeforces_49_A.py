s = input()
ch = None

# Find the last character that is not ' ' or '?'
for i in range(len(s) - 1, -1, -1):
    char = s[i]
    if char != ' ' and char != '?':
        ch = char
        break

if ch is not None:
    # Convert to lowercase and check if it is a vowel
    ch_lower = ch.lower()
    if ch_lower in 'aeiouy':
        print("YES")
    else:
        print("NO")
else:
    # If no such character was found, the result is NO (mimicking the Java behavior where ch=0 leads to NO)
    print("NO")