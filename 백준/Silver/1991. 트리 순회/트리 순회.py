from sys import stdin as s

n = int(s.readline())


graph = [[] for _ in range(n+1)]



def preorder(num):
    if num >=0:
        print(chr(num+65),end='')
        preorder(graph[num][0])
        preorder(graph[num][1])     

def inorder(num):
    if num >=0:
        inorder(graph[num][0])
        print(chr(num+65),end='')
        inorder(graph[num][1])        

def postorder(num):
    if num >=0:
        postorder(graph[num][0])
        postorder(graph[num][1])        
        print(chr(num+65),end='')


for i in range(n):
    x , lo1,lo2 = list(map(str,s.readline().rstrip().split()))
    graph[ord(x) - 65].append(ord(lo1) - 65)
    graph[ord(x) - 65].append(ord(lo2) - 65)



preorder(0)
print()
inorder(0)
print()
postorder(0)


