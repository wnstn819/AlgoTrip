from sys import stdin as s

n = int(s.readline())

arr = list(map(int,s.readline().split()))

cal = list(map(int,s.readline().split()))

resultMax = -int(1e9)

resultMin = int(1e9)

def DFS(num,ans,li):
    global resultMax
    global resultMin
    if sum(cal) == 0:
        resultMax = max(resultMax,ans)
        resultMin = min(resultMin,ans)
        return
    
    for i in range(4):
        if cal[i] !=0:
            cal[i] -= 1
            li.append(i)
            prev = TEST(i,ans,arr[num+1])
            DFS(num+1,prev,li)
            li.pop()
            cal[i] +=1


def TEST(num,a,b):
    if num == 0:
        return a+b
    elif num == 1:
        return a-b
    elif num ==2:
        return a*b
    else:
        if a < 0:
            result = -(-a // b)
        else:
            result = a//b
        return result


DFS(0,arr[0],[])


print(resultMax)
print(resultMin)