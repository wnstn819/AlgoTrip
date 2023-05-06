from sys import stdin as s
n = int(s.readline())

def hanoi(n,start, sub,goal): # 1 -> 2번을 통해 3번으로
    if n == 1:
        print(start,goal)
        return
    hanoi(n-1, start, goal,sub) # 1 -> 3번을 통해 2번으로
    print(start, goal)
    hanoi(n-1, sub,start, goal) # 2 -> 1번을 통해 3번으로

print((2 ** n) - 1)

if n <= 20:
    hanoi(n,1,2,3)

