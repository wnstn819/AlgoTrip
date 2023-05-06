from sys import stdin as s

s = open('input.txt','rt')


N, S = list(map(int,s.readline().split()))

arr = list(map(int,s.readline().split()))

count =0
li = []
def dfs(num):
    global count
    print(li)
    if sum(li) == S and len(li) >0:
        count +=1
        
    for i in range(num,N):
        li.append(arr[i])
        dfs(i+1)
        li.pop()



dfs(0)
print(count)







