import sys

def main():
    # Read all input tokens separated by whitespace
    try:
        data = sys.stdin.read().split()
    except:
        return

    input_iter = iter(data)

    for i in range(5):
        try:
            # Simulate sc.nextInt()
            num_str = next(input_iter)
            num = int(num_str)
            
            if num == 0:
                print(i + 1)
                break
        except StopIteration:
            # Ran out of input before 5 numbers were read
            break
        except ValueError:
            # Input was not an integer, skip this number
            continue

if __name__ == "__main__":
    main()
