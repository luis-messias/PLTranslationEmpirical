import sys

def solve():
    # Read the input line (which is expected to be the string)
    try:
        # Read the entire line and strip whitespace
        s = sys.stdin.readline().strip()
    except:
        # Handle case where input might be empty or error occurs
        return

    # Step 1: Perform the replacement (Java: s.replaceAll("BC", "D"))
    s = s.replace("BC", "D")

    cnt = 0
    tmp = 0
    
    # Step 2: Iterate and calculate the count
    for char in s:
        if char == 'A':
            tmp += 1
        elif char == 'D':
            # When 'D' is encountered, add the accumulated count of preceding 'A's
            cnt += tmp
        else:
            # If any other character is encountered, reset the count of consecutive 'A's
            tmp = 0
            
    # Step 3: Output the result
    print(cnt)

if __name__ == "__main__":
    solve()