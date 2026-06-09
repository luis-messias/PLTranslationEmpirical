import sys

def main():
    num_list = []
    for _ in range(5):
        num_list.append(int(input()))
    k = int(input())
    if abs(num_list[4] - num_list[0]) > k:
        print(":(")
    else:
        print("Yay!")

if __name__ == "__main__":
    main()