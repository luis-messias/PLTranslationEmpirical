import sys

def solve():
    input_str = input()
    char_list = list(input_str)
    
    if char_list[0] == char_list[1] or char_list[1] == char_list[2] or char_list[2] == char_list[0]:
        print("No")
    else:
        print("Yes")

if __name__ == "__main__":
    try:
        solve()
    except Exception as e:
        print(e)