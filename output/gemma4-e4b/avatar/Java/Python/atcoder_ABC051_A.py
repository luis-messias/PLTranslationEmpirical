def main():
    try:
        # Read the single line input
        a = input()
    except EOFError:
        a = ""
    
    # Replace commas with spaces and print the result
    print(a.replace(",", " "))

if __name__ == "__main__":
    main()