import sys

class IntegralRect:
    def __init__(self, height, width):
        self.height = height
        self.width = width
    
    def diagonal(self):
        if self.height >= self.width:
            return float('inf')
        return self.height * self.height + self.width * self.width
    
    def compare_to(self, other):
        d1 = self.diagonal()
        d2 = other.diagonal()
        # Uncomment the following line for debugging
        # print(d1, d2)
        if d1 == d2:
            return self.height - other.height
        else:
            return d1 - d2

def main():
    rects = [IntegralRect(i + 1, j + 1) for i in range(200) for j in range(200)]
    
    # Sort the rectangles based on their diagonal length and height (for debugging)
    # rects.sort(key=lambda x: (-x.diagonal(), -x.height))
    
    while True:
        line = sys.stdin.readline().strip()
        if not line or len(line.split()) == 0:
            break
        h, w = map(int, line.split())
        
        tmp_rect = IntegralRect(h, w)
        for rect in sorted(rects):
            # Uncomment the following lines for debugging
            # print(f"{rect.height} {rect.width}")
            if rect.compare_to(tmp_rect) > 0:
                break

if __name__ == "__main__":
    main()