from collections import deque
import sys
input = sys.stdin.readline

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]
def bfs(i, j):
    global result, map_island, w, h
    q = deque()
    q.append((i, j))
    while q:
        x, y = q.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < h and 0 <= ny < w and map_island[nx][ny] == 1:
                map_island[nx][ny] = 0
                q.append((nx, ny))
        

def main():
    global result, map_island, w, h
    map_island = []
    result = []
    cnt = 0
    while True:
        map_island = []
        w, h = map(int, input().split())
        if w == 0 and h == 0:
            break
        else:
            for i in range(h):
                map_island.append(list(map(int, input().split())))
            for i in range(h):
                for j in range(w):
                    if map_island[i][j] == 1:
                        cnt += 1
                        bfs(i, j)
            result.append(cnt)
            cnt = 0
    for i in result:
        print(i)



if __name__ == "__main__":
    main()