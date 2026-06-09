from decimal import Decimal, ROUND_DOWN

input_data = input().split()
A = Decimal(input_data[0])
B = Decimal(input_data[1])
result = A * B
print(int(result.quantize(Decimal('1'), rounding=ROUND_DOWN)))
