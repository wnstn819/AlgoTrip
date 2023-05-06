from sys import stdin as s

s = open('input.txt','rt')

a, b = map(int,s.readline().split())

h = []
h.append(b)
h.append(0)

w = []
w.append(a)
w.append(0)

t = int(s.readline())

for _ in range(t):
    c, d = map(int,s.readline().split())
    if c == 0:
        h.append(d)
    else:
        w.append(d)
    

h.sort()
w.sort()


hmax = 0
for i in range(0,len(h)-1):
    if h[i+1] - h[i] > hmax:
        hmax = (h[i+1] - h[i])
        
    
wmax= 0
for i in range(0,len(w)-1):
    if w[i+1] - w[i] > wmax:
        wmax = (w[i+1] - w[i])


print(hmax * wmax)
