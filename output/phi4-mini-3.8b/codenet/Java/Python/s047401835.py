N = int(input())
numbers = [int(x) for x in input().split()]

count = 0

while True:
    numbers = list(map(lambda i: i // 2, filter(lambda i: (i % 2 == 0), numbers)))
    
    if len(numbers) != N or not all(n > 0 and n.is_integer() for n in numbers):
        break
    
    count += 1

print(count)