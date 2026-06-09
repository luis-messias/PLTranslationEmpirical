import sys

def solve():
    # Read all tokens from standard input
    data = sys.stdin.read().split()
    
    if not data:
        return

    # h and w are the first two elements
    try:
        h = int(data[0])
        w = int(data[1])
    except IndexError:
        return

    # The content strings start from index 2
    content_tokens = data[2 : 2 + h]
    
    # 1. Print top border (length w + 2)
    top_bottom_border = '#' * (w + 2)
    print(top_bottom_border)
    
    # 2. Print content
    for s in content_tokens:
        # Java logic: ans[i] = "#" + scanner.next() + "#";
        print("#" + s + "#")
        
    # 3. Print bottom border
    print(top_bottom_border)

if __name__ == "__main__":
    solve()