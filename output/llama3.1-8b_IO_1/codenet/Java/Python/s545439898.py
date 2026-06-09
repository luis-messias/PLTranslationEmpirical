import sys

def main():
    count = int(input())
    giving_numbers = []
    
    # Read Numbers
    for _ in range(count):
        num = input().split()[0]
        giving_numbers.append(int(num))
        
    # Reversing Numbers
    for i in range(len(giving_numbers) - 1, -1, -1):
        print(giving_numbers[i], end=' ')
        
    print()
    
if __name__ == "__main__":
    main()
