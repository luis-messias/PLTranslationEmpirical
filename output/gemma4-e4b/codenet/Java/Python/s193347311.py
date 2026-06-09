import sys

def main():
    # Read all input tokens from standard input
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # The first element is the loop count
        int_loop = int(data[0])
    except ValueError:
        return

    int_taro = 0
    int_hana = 0
    
    data_index = 1
    
    for _ in range(int_loop):
        if data_index + 1 >= len(data):
            break
            
        str_taro = data[data_index]
        str_hana = data[data_index + 1]
        
        data_index += 2
        
        # Comparison logic based on Java's compareTo:
        # < 0 means str_taro < str_hana
        # == 0 means str_taro == str_hana
        # > 0 means str_taro > str_hana
        
        if str_taro < str_hana:
            # intJudge < 0
            int_hana += 3
        elif str_taro == str_hana:
            # intJudge == 0
            int_taro += 1
            int_hana += 1
        else: # str_taro > str_hana
            # intJudge > 0
            int_taro += 3
            
    print(f"{int_taro} {int_hana}")

if __name__ == "__main__":
    main()