import sys

def main():
    sc = input()
    a, b, t = map(int, sc.split())
    time = 0
    count = 0
    while time < t + 0.5:
        count += b
        time += a
        if time > t + 0.5:
            count -= b
            break
    print(count)

if __name__ == "__main__":
    main()