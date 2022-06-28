## 처음 접근했을 때는 dfs로만 풀고싶어 한번의 레벨마다 q의 개수를 체크해서 그거만큼만 while을 돌고 
## level + 1을 해주고 다시 while을 도는 방식 -> 로직이 잘못됨
## dp + bfs

from collections import deque
import sys
input = sys.stdin.readline

def bfs():
    global dist, start, end
    lev = 0
    q = deque()
    q.append(start)
    while q:
        now = q.popleft()
        if now == end:
            return
        for i in (now - 1, now + 1, now * 2):
            if 0 <= i < 100001 and dist[i] == 0 :
                dist[i] = dist[now] + 1
                q.append(i)
            
def main():
    global dist, start, end
    start, end = map(int, input().split())
    dist = [0] * (100001)
    bfs()
    print(dist[end])

if __name__ == "__main__":
    main()