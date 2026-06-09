def main():
    # Read the input day string
    s = input()
    
    # Define the days of the week array
    youbi = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]
    
    ans = 0
    
    # Iterate through the days and find the match
    for i in range(len(youbi)):
        if youbi[i] == s:
            ans = 7 - i
            # Since the day is unique, we can break after finding it
            break
            
    print(ans)

if __name__ == "__main__":
    main()