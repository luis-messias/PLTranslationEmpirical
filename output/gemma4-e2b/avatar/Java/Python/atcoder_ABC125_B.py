import sys

def str2list(str_in):
    values = str_in.split()
    result = {}
    for i, val in enumerate(values):
        result[i] = int(val)
    return result

def main():
    # Read input from stdin
    input_data = sys.stdin.read().splitlines()
    
    if len(input_data) < 3:
        return

    try:
        n = int(input_data[0])
        vStr = input_data[1]
        cStr = input_data[2]
    except ValueError:
        return

    vList = str2list(vStr)
    cList = str2list(cStr)
    
    max_profit = 0
    
    # Iterate n times, corresponding to the indices 0 to n-1
    for i in range(n):
        # Accessing elements directly since str2list ensures sequential mapping
        profit = vList[i] - cList[i]
        if profit >