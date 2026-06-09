import sys

def main():
    a, tA = map(int, input().split())
    b, tB = map(int, input().split())
    timing = input()
    hrs, mins = int(timing[:2]), int(timing[3:])
    sim_departure = hrs * 60 + mins
    sim_arrival = sim_departure + tA

    counter = 0
    for i in range(300, 1440, b):
        bus_departure, bus_arrival = i, i + tB
        if bus_departure >= sim_arrival or sim_departure >= bus_arrival:
            continue
        counter += 1

    print(counter)

if __name__ == "__main__":
    main()