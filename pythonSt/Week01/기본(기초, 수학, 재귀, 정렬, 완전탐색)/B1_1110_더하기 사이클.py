from sys import stdin as s

s = open('input.txt','rt')

n = int(s.readline())

def test(num,depth):
    
    if num == n and depth != 0:
        print(depth)
        return
    
    s = num // 10
    d = num % 10
    sum = s+d
    result = (d*10) + (sum%10)
    test(result,depth +1)


test(n,0)

