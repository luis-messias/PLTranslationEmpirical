import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    x = int(input_data[1])
    
    max_val = n * 2 - 1
    
    if x == 1 or x == max_val:
        print("No")
        return
    
    print("Yes")
    
    sep = '\n'