import sys

class IntegralRect:
    def __init__(self, h, w):
        self.height = h
        self.width = w

    def diagonal(self):
        # Java logic: if height >= width, return Integer.MAX_VALUE
        if self.height >= self.width:
            return sys.maxsize
        return self.height**2 + self.width**2

    def compareTo(self, o):
        # Java logic: compare based on diagonal, then height (descending)
        d1 = self.diagonal()
        d2 = o.diagonal()

        if d1 != d2:
            return d1 - d2
        else:
            # If diagonals are equal, sort by height descending (this.height - o.height)
            return self.height - o.height

def solve():
    # Read all input lines first, as the loop structure implies continuous reading
    input_data = sys.stdin.read().splitlines()
    
    if not input_data:
        return

    # Initialize BufferedReader equivalent (using input_data iterator)
    line_index = 0
    
    # 1. Initialize and populate rects array
    rects = []
    
    # Populate 200x200 rectangles
    for i in range(1, 201):
        for j in range(1, 201):
            rects.append(IntegralRect(i, j))

    # 2. Sort the rectangles using the custom comparison logic
    # Python's sort uses the __lt__ or custom key, but since we implemented compareTo, 
    # we use functools.cmp_to_key for sorting based on the Java logic.
    from functools import cmp_to_key
    rects.sort(key=cmp_to_key(lambda a, b: a.compareTo(b)))

    # 3. Process queries
    while line_index < len(input_data):
        line = input_data[line_index].strip()
        if not line:
            line_index += 1
            continue
            
        try:
            tmpArray = line.split()
            if len(tmpArray) < 2:
                line_index += 1
                continue
                
            h = int(tmpArray[0])
            w = int(tmpArray[1])
        except ValueError:
            line_index += 1
            continue

        if h == 0 and w == 0:
            break

        tmpRect = IntegralRect(h, w)
        
        # Search for the first rectangle rects[i] such that rects[i].compareTo(tmpRect) > 0
        found = False
        for rect in rects:
            # We need to check if rect is "greater" than tmpRect according to the sort order.
            # Since rects is sorted ascending by diagonal, we are looking for the first element 
            # whose diagonal is strictly greater than tmpRect's diagonal, or if diagonals are equal, 
            # whose height is smaller (due to descending height sort).
            
            # The Java code checks: if(rects[i].compareTo(tmpRect) > 0)
            if rect.compareTo(tmpRect) > 0:
                print(f"{rect.height} {rect.width}")
                found = True
                break
        
        # If no such rectangle is found (which shouldn't happen if the search logic is sound 
        # and the input space is covered, but we follow the loop structure)
        if not found:
            # If the loop finishes without finding a match, we continue to the next input line
            pass
            
        line_index += 1

if __name__ == "__main__":
    solve()