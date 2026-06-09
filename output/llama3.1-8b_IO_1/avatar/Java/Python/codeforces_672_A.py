import string

def generate_string():
    return ''.join(str(i) for i in range(1, 1001))

def main():
    n = int(input()) - 1
    print(generate_string()[n])

if __name__ == "__main__":
    main()
