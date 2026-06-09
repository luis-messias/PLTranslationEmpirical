import sys

def main():
    input_data = sys.stdin.read().split()
    iterator = iter(input_data)
    
    while True:
        try:
            number = int(next(iterator))
            if number == 0:
                break
            
            score = []
            for _ in range(number):
                score.append(int(next(iterator)))
            
            score.sort()
            sum_val = 0
            for i in range(1, number - 1):
                sum_val += score[i]
            print(sum_val // (number - 2))
        except StopIteration:
            break

if __name__ == "__main__":
    main()
