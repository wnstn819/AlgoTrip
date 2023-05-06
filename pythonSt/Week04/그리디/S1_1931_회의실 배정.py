from sys import stdin as s
s= open('input.txt','rt')

N = int(s.readline())

arr = [list(map(int,s.readline().split())) for _ in range(N)]

arr.sort(key= lambda x: (x[1],x[0]))

count =0

end =0
for i in arr:
    if i[0] >= end:
        count +=1
        end = i[1]

print(count)




