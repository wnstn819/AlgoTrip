n = int(input())
for i in range(0,n):
    a = list(map(int, input().split()))
    del a[0]
    sumAll = sum(a)
    avg = sumAll/len(a)
    avgOver = 0
    for j in a:
        if j > avg :
            avgOver += 1
    


    print("%.3f%%"%(avgOver/len(a)* 100.0))
    