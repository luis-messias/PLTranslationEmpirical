import sys

def main():
    input_data = sys.stdin.read().split()
    intLoop = int(input_data[0])
    idx = 1
    intTaro = 0
    intHana = 0
    
    for _ in range(intLoop):
        strTaro = input_data[idx]
        strHana = input_data[idx + 1]
        idx += 2
        
        if strTaro < strHana:
            intHana += 3
        elif strTaro == strHana:
            intTaro += 1
            intHana += 1
        else:
            intTaro += 3
    
    print(intTaro, intHana)

if __name__ == "__main__":
    main()
