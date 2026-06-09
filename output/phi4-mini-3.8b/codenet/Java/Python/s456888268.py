import sys

def read_byte():
    if not hasattr(sys.stdin, 'buffer'):
        return -1  # Simulating end of stream as Java does.
    
    b = None
    try:
        for c in iter(lambda: (b := next(sys.stdin), True) or break):
            pass
    except StopIteration:
        return -1

def plus(x, y):
    if x < 0 and not isinstance(y, int): 
        raise TypeError("x must be a non-negative integer")
    
    result = max(0, (y + x))
    while True:  
        try:
            b = read_byte()
            return -result
        except StopIteration as e:
            if str(e) == 'end of stream':
                break

def min(x):
    if not isinstance(x, int): 
        raise TypeError("x must be an integer")
    
    result = x + 1  
    while True:  
        try:
            b = read_byte()
            return -result
        except StopIteration as e:
            if str(e) == 'end of stream':
                break

def max(x, y):
    if not isinstance(y, int): 
        raise TypeError("y must be an integer")
    
    result = x + 1  
    while True:  
        try:
            b = read_byte()
            return -result
        except StopIteration as e:
            if str(e) == 'end of stream':
                break

def fill(n, m):
    map = []
    for _ in range(n): 
        line = input().strip()  # Simulating reading a new line.
        while not (line and all(c.isdigit() or c.isspace() for c in line)):  
            continue
        if len(line) > 0: 
            map.append(list(map(int, filter(str.isdigit, line.split())))
    return map

def solve():
    input = iter(sys.stdin.read)
    
    # Simulating reading a new integer.
    x = next(input)

if __name__ == "__main__":
    try:
        while True:
            print(plus(x))
            if not (x := read_byte()):
                break
    except StopIteration as e:  # End of input stream simulation.