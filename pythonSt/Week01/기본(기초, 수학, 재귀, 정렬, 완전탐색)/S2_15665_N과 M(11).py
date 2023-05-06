from sys import stdin as s

s = open('input.txt','rt')

N, M = map(int, s.readline().split())
list = list(map(int, s.readline().split()))
li = []

list = sorted(list)

def dfs():
    if len(li) == M:
        for i in li:
            print(i, end=" ")
        print()
        return
    remember =0
    for i in range(N):
        if remember != list[i]:
           
            li.append(list[i])
            remember = list[i]
            dfs()
            li.pop()

dfs()