import math

def main():
    try:
        n_str = input()
        n = int(n_str)
    except EOFError:
        return
    except ValueError:
        return

    sqrt_val = math.sqrt(n)
    near_num = math.floor(sqrt_val)

    # Calculate near_num squared. Since near_num is a float (from math.floor),
    # we cast it to int/long before squaring to ensure the result is an integer type.
    ans = int(near_num ** 2)

    print(ans)

if __name__ == "__main__":
    main()