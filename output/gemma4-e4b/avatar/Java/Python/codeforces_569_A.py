import sys

def solve():
    # Read all inputs from standard input
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        
        # The inputs are T, S, q
        T = int(data[0])
        S = int(data[1])
        q = int(data[2])
    except Exception as e:
        # Handle case where input might be malformed or empty
        return

    # The logic from the Java code:
    # while ( previous < T ) { answer ++ ; previous *= q ; }
    
    previous = S
    answer = 0
    
    # We need to find the smallest 'answer' such that S * q^answer >= T
    # Or, equivalently, the number of multiplications by q needed until the result reaches or exceeds T.
    
    while previous < T:
        answer += 1
        # Check for potential overflow if using fixed-size integers, 
        # but Python handles large integers automatically.
        previous *= q
        
    print(answer)

if __name__ == "__main__":
    solve()