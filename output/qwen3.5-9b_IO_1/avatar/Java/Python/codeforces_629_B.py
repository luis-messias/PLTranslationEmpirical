import sys

def main():
    sc = sys.stdin.read().split()
    idx = 0
    n = int(sc[idx])
    idx += 1
    
    FfriendPerDay = [0] * 367
    MfriendPerDay = [0] * 367
    
    answer = 0
    
    for _ in range(n):
        c = sc[idx]
        idx += 1
        a = int(sc[idx])
        idx += 1
        b = int(sc[idx])
        idx += 1
        
        for j in range(a, b + 1):
            if c == 'M':
                MfriendPerDay[j] += 1
            else:
                FfriendPerDay[j] += 1
            
            if MfriendPerDay[j] < FfriendPerDay[j]:
                if MfriendPerDay[j] > answer:
                    answer = MfriendPerDay[j]
            else:
                if FfriendPerDay[j] > answer:
                    answer = FfriendPerDay[j]
    
    print(answer * 2)

if __name__ == "__main__":
    main()
