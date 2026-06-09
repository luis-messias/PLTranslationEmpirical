def main():
    # Read integer input
    try:
        intA = int(input())
    except EOFError:
        return
    except ValueError:
        # Handle case where input is not a valid integer
        return

    # Calculate the cube (intA^3)
    # Using ** operator is idiomatic Python for exponentiation
    cube = intA ** 3

    # Print the result (which is already an integer)
    print(cube)

if __name__ == "__main__":
    main()