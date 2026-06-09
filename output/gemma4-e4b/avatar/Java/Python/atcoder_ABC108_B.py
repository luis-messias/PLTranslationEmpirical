import sys

def revpos(p, q):
    # p and q are expected to be lists/tuples of length 2
    
    # Calculate vec = p - q
    v0 = p[0] - q[0]
    v1 = p[1] - q[1]
    
    # Apply transformation: (v0, v1) -> (v1, -v0)
    # The Java code calculates vec[0] = v1, vec[1] = -v0
    
    # Calculate newpos = q + vec
    # newpos[0] = q[0] + v1
    # newpos[1] = q[1] + (-v0)
    
    newpos = [
        q[0] + v1,
        q[1] - v0
    ]
    return newpos

def main():
    # Read 4 integers from standard input
    try:
        data = list(map(int, sys.stdin.read().split()))
    except:
        # Handle case where no input is provided
        data = [0, 0, 0, 0]

    if len(data) < 4:
        # Ensure we have at least 4 elements, padding if necessary for robustness
        data.extend([0] * (4 - len(data)))

    input_data = data[:4]

    # Initialize positions (using lists for mutable coordinates)
    # position[0] = (input[0], input[1])
    # position[1] = (input[2], input[3])
    
    position = [
        [input_data[0], input_data[1]],
        [input_data[2], input_data[3]],
        [0, 0],
        [0, 0]
    ]

    # Calculate position[2]
    position[2] = revpos(position[0], position[1])
    
    # Calculate position[3]
    position[3] = revpos(position[1], position[2])

    # Check condition: position[0] == revpos(position[2], position[3])
    # In Python, list comparison checks content equality, matching the likely intent of the Java code.
    if position[0] == revpos(position[2], position[3]):
        print("OK")

    # Calculate output
    output = [
        position[2][0],
        position[2][1],
        position[3][0],
        position[3][1]
    ]

    # Print output elements, each on a new line
    for i in output:
        print(i)

if __name__ == "__main__":
    main()