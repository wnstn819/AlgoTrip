from sys import stdin as s

s = open('input.txt','rt')

#arr = list(s.readline().rstrip())

arr = list(map(str, s.readline().rstrip()))
print(arr)

ppap = []

for i in range(len(arr)):
    ppap.append(arr[i])
    if ppap[-4:] == ["P","P","A","P"]:
        for _ in range(4):
            ppap.pop()
    
        ppap.append("P")
        
   



if ppap == ["P"] or ppap==["P","P","A","P"]:
    print("PPAP")
else:
    print("NP")