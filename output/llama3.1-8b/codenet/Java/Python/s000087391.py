import sys

def main():
    result = []
    n = -1
    while True:
        line = input()
        try:
            n = int(line)
        except ValueError:
            print("Invalid input. Please enter a number.")
            continue
        if n == 0:
            break
        array2 = line.split()
        input_list = [int(i) for i in array2]
        sum_val = sum(input_list)
        avg = sum_val / len(input_list)
        num = sum(1 for i in input_list if i <= avg)
        result.append(num)

    for item in result:
        if item == -1:
            print("NONE")
        else:
            print(item)

if __name__ == "__main__":
    main()