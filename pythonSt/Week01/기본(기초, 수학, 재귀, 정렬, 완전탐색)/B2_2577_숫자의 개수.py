from sys import stdin as s


s = open('input.txt', 'rt')

a,b,c = map(int,s.readlines())

# result = int(a*b*c)
# temp = [0,0,0,0,0,0,0,0,0,0]
# while result > 10 :
#      temp[int(result%10)] += 1
#      result /= 10
#      result = int(result)

# temp[result] +=1


# for i in temp:
#      print(i)


result = a*b*c

for i in range(10):
     print(str(result).count(str(i)))






