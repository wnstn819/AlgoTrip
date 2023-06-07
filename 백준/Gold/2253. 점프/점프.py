from collections import deque
import sys
N, M = map(int, sys.stdin.readline().split())
check = [[] for _ in range(N + 1)]
# 리스트로하면 시간초과남
small = set()
for _ in range(M):
    small.add(int(sys.stdin.readline().strip()))


def jumpRock(N, check, small):
    q = deque()
    q.append((1, 0, 0))
    while q:
        curr_rock, move, cnt = q.popleft()
        for jump in [move-1, move, move+1]:
            if jump > 0:
                next_rock = curr_rock + jump
                if next_rock == N:
                    return cnt + 1
                if next_rock > N:
                    continue
                if move not in check[next_rock] and next_rock not in small:
                    check[next_rock].append(jump)
                    q.append((next_rock, jump, cnt+1))

    return -1


print(jumpRock(N, check, small))