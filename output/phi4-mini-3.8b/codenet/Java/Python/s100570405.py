import sys

class MyInput:
    def __init__(self):
        self.buffer = bytearray(1024)
        self.ptr, self.buflen = 0, len(self.buffer)

    def has_next_byte(self) -> bool:
        if self.ptr < self.buflen: return True
        while not self.has_next() and (b := sys.stdin.read(1)):
            pass

def run():
    input_stream = MyInput()
    
    Sd = input_stream.next().strip()
    T = input_stream.next().strip()

    count, first, end = 0, -1, -1
    ok = False
    
    for j in range(len(Sd)):
        count = 0
        
        for i in range(j + len(T) - 1):
            if (i < len(Sd)) and ((Sd[i] == '?' or Sd[i] == T[count]) and count < len(T)):
                count += 1
                first, end = j+count-len(T)+1, j+count
                
        ok |= first != -1

    result = []
    
    if ok:
        for i in range(len(Sd)):
            if first <= i <= end: 
                result.append(T[i-first])
            else:
                result.append('a' if Sd[i] == '?' else Sd[i])

        print("".join(result))
        
    else:
        sys.stdout.write("UNRESTORABLE\n")

if __name__ == "__main__":
    run()