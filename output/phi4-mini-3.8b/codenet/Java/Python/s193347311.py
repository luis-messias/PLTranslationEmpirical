import sys

intLoop = int(sys.stdin.readline().strip())
str_taro, str_hana = '', ''
int_taro, int_hana = 0, 0

for _ in range(intLoop):
    str_taro = input()
    str_hana = input()

    if str_taro < str_hana:
        int_hana += 3
    elif str_taro == str_hana:
        int_taro += 1
        int_hana += 1
    else: # Assuming the comparison is for strings that are not equal and in a case where Python's default behavior would be to compare lexicographically.
        int_taro += 3

print(int_taro, int_hana)