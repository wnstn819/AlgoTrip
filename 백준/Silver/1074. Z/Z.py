from sys import stdin as s

N, r, c = map(int, s.readline().split())

ans = 0

def z(n,x,y):
    global ans
    if x == r and c == y :
        print(ans)
        exit(0)
    

    if n == 1:
        ans +=1
        return
        
    
    if not (x <= r < n+x  and y <= c < n+y):
        ans += n*n
        return
        
        
    z(n//2, x, y)
    z(n//2, x, y + n//2)
    z(n//2, x +n//2, y)
    z(n//2, x + n//2, y + n//2)
    
z(2**N,0,0)




