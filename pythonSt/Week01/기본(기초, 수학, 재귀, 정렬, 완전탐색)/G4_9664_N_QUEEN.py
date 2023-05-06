from sys import stdin as a

s = open('input.txt', 'rt')

n = int(s.readline())


pos = [0] * 8
flag_a = [False] * 8
flag_b = [False] * 15
flag_c = [False] * 15




print(pos)

# def put() -> None:
#     for i in range(8):
#         print(f'{pos[i]:2}', end = '')
#     print()

def put() -> None:
    for j in range(8):
        for i in range(8):
            print('◼️' if pos[i] == j else '◻️', end= '')
        print()
    print()

def set(i: int) -> None:
       for j in range(8):
        if( not flag_a[j] and not flag_b[i + j] and not flag_c[i - j + 7]):
            # j행에 퀸이 배치되지 않았다면
            # 대각선 방향 좌하, 우상 으로 퀸이 배치되지 않았다면
            # 대각선 방향 우하, 좌상 으로 퀸이 배치되지 않았다면
            # 퀸을 j행에 배칯
            # 모든 열에 퀸을 배치 완료
            pos[i] = j
            if i == 7:
                put()
            else:
                flag_a[j]  = flag_b[i+j]  = flag_c[i - j +7] = True
                set(i+1)
                flag_a[j] = flag_b[i + j] = flag_c[i -j + 7] = False 


set(0)