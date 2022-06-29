from collections import deque
import sys
input = sys.stdin.readline

dx = [-1, 0 , 1, 0]
dy = [0, 1, 0, -1]

def ch_bfs(i, j):
    global n, l, r, grid, visited
    q = deque()
    q.append((i, j))
    country_coor = []
    country_coor.append((i, j))
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == 0:
                if l <= abs(grid[nx][ny] - grid[x][y]) <= r:
                    visited[nx][ny] = 1
                    q.append((nx, ny))
                    country_coor.append((nx, ny))
    return country_coor

# def bfs():
#     global n, l, r, grid, visited, isStop, cnt
#     q = deque()
#     q.append((0, 0))
#     visited[0][0] = 1
#     country_cnt = 0
#     country_val = 0
#     country_coor = []
#     while q:
#         x, y = q.popleft()
#         for i in range(4):
#             nx = x + dx[i]
#             ny = y + dy[i]
#             if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == 0:
#                 visited[nx][ny] = 1
#                 q.append((nx, ny))
#                 if l <= abs(grid[nx][ny] - grid[x][y]) <= r:    
#                     country_cnt += 1
#                     country_val += grid[nx][ny]
#                     country_coor.append((nx, ny))
#     if len(country_coor) == 0:
#         isStop = True
#     while country_coor:
#         x, y = country_coor.pop()
#         print(country_val//country_cnt)
#         grid[x][y] = country_val//country_cnt 

def main():
    global n, l, r, grid, visited, isStop, cnt
    n, l, r = map(int, input().split())
    grid = [list(map(int, input().split())) for _ in range(n)]
    visited = [[0 for _ in range(n)] for _ in range(n)]
    cnt = 0
    while True:
        visited = [[0 for _ in range(n)] for _ in range(n)]
        isStop = True
        for i in range(n):
            for j in range(n):
                if visited[i][j] == 0:
                    visited[i][j] = 1
                    country_coor = ch_bfs(i, j)
                    if len(country_coor) > 1:
                        isStop = False
                        country_val = sum(grid[x][y] for x, y in country_coor) // len(country_coor)
                        for x, y in country_coor:
                            grid[x][y] = country_val
        if isStop:
            break
        cnt += 1
    print(cnt)

if __name__ == "__main__":
    main()