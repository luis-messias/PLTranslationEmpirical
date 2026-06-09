import re

def main():
    s = input()
    dot_index = s.find('.')

    if dot_index != -1 and s[dot_index-1] == '9':
        print("GOTO Vasilisa.")
    elif int(s[dot_index+1:]) > 4:
        _str = s[:dot_index]
        print(int(_str) + 1)
    else:
        print(s[:dot_index])

if __name__ == "__main__":
    main()