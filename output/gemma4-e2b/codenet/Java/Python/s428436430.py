class calArea:
    def Area(self, w, h):
        area = w * h
        return area

if __name__ == "__main__":
    # Read 4 integers from standard input
    try:
        # Read all input and convert to integers
        input_data = list(map(int, input().split()))
        
        if len(input_data) < 4:
            # Handle case where not enough input is provided, though typically competitive programming assumes correct input format
            exit()

        arr = input_data
        
        # Calculate areas
        ab = calArea()
        area1 = ab.Area(arr[0], arr[1])
        area2 = ab.Area(arr[2], arr[3])
        
        # Determine the larger area and print it
        if area1 >= area2:
            print(area1)
        else:
            print(area2)
            
    except EOFError:
        # Handle end of file if input reading fails unexpectedly
        pass
    except ValueError:
        # Handle case where input cannot be converted to int
        pass