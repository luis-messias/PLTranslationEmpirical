import input

if __name__ == "__main__":
    
    s = input()
    if (s) and (s.lower() is "sunny"):
        print("cloudy")
    elif (s and (s.lower() is "cloudy")):
        print("rainy")
    else: 
        print("Sunny")