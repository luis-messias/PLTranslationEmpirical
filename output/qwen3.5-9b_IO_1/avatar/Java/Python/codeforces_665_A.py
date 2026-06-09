import sys

def main():
    line1 = sys.stdin.readline().split()
    a = int(line1[0])
    tA = int(line1[1])
    
    line2 = sys.stdin.readline().split()
    b = int(line2[0])
    tB = int(line2[1])
    
    timing = sys.stdin.readline().strip()
    hrs = int(timing[:2])
    mins = int(timing[3:])
    
    simDeparture = hrs * 60 + mins
    simArrival = simDeparture + tA
    
    counter = 0
    for i in range(300, 1440, b):
        busDeparture = i
        busArrival = i + tB
        if busDeparture >= simArrival or simDeparture >= busArrival:
            continue
        counter += 1
    
    print(counter)

if __name__ == "__main__":
    main()
