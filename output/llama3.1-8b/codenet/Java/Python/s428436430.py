import math

class CalArea:
    def area(self, w, h):
        return w * h

def main():
    arr = input().split()
    ab = CalArea()
    area1 = ab.area(int(arr[0]), int(arr[1]))
    area2 = ab.area(int(arr[2]), int(arr[3]))

    if area1 > area2:
        print(area1)
    elif area1 < area2:
        print(area2)
    else:
        print(area1)

if __name__ == "__main__":
    main()