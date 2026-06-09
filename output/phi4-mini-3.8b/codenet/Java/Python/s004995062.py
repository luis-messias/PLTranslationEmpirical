import decimal

def main():
    sa = input()
    sb = input()

    A = decimal.Decimal(sa)
    B = decimal.Decimal(sb)

    result = (A * B).to_integral_value(rounding=decimal.ROUND_DOWN)
    
    print(result)

if __name__ == "__main__":
    main()