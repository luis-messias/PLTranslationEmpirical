import queue

q = queue.Queue()

while True:
    a = input()
    
    if not a: break
    
    try:
        a = int(a)
        
        if a == 0 and not q.empty():
            print(q.get_nowait())
        else:
            q.put(a)
    except ValueError as e:
        continue