from cmath import e
from collections import deque
import sys
input = sys.stdin.readline
dx = [-1, 0 , 1, 0]
dy = [0, 1, 0, -1]
apt_cnt = []
cnt = 0
def bfs(s, e):
    global aptarr, n, cnt
    q = deque()
    q.append([s, e])
    while q:
        now = q.popleft()
        for i in range(4):
            if 0 <= now[0] + dx[i] < n and 0 <= now[1] + dy[i] < n:
                if aptarr[now[0] + dx[i]][now[1] + dy[i]] == '1':
                    aptarr[now[0] + dx[i]][now[1] + dy[i]] = '0'
                    q.append([now[0] + dx[i], now[1] + dy[i]])
                    cnt += 1
                elif aptarr[now[0]][now[1]] == '1':
                    cnt += 1
                    aptarr[now[0]][now[1]] = '0'
    apt_cnt.append(cnt)

def main():
    global aptarr, n, cnt
    n = int(input())

    aptarr = []
    for _ in range(n):
        s = input()
        aptarr.append(list(s[:]))

    for s in range(n):
        for e in range(n):
            if aptarr[s][e] == '1':
                bfs(s, e)
                cnt = 0

    print(len(apt_cnt))
    
    apt_cnt.sort()
    for i in apt_cnt:
        print(i)

if __name__ == "__main__":
    main()