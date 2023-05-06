def solution(book_time):
    answer = 0
    book_time.sort()
    room = [0]
    for i in book_time:
        hour = int(i[0][0:2]) * 60
        minut = int(i[0][3:5])
        first = hour + minut
        
        shour = int(i[1][0:2]) * 60
        sminut = int(i[1][3:5])
        second = shour + sminut

        for j in range(len(room)):
            if room[j] <= first:
                room[j] = second +10
                break
            
            if j == len(room)-1:
                room.append(second+10)
                
                
    answer=  len(room)
    print(answer)
    return answer


solution([["00:01", "00:10"], ["00:19", "00:29"]])
## 틀림