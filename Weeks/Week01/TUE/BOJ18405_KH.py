from collections import deque
import sys
input = sys.stdin.readline
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def bfs(virus, s):
    q = deque(virus)
    time = 0
    while q:
        t, time, now_x, now_y = q.popleft()
        if time == s:
            return
        for i in range(4):
            nx = now_x + dx[i]
            ny = now_y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and birus_arr[nx][ny] == 0 :
                birus_arr[nx][ny] = t
                q.append((t, time + 1, nx, ny))

def main():
    global birus_arr, q, n
    n, k = map(int, input().split())
    birus_arr = []
    for _ in range(n):
        birus_arr.append(list(map(int, input().split())))
    s, x, y = map(int, input().split())

    q = []
    for i in range(n):
        for j in range(n):
            if birus_arr[i][j] != 0:
                q.append((birus_arr[i][j], 0, i, j))

    q.sort(key=lambda x:x[0])
    bfs(q, s)
    
    print(birus_arr[x - 1][y - 1])


if __name__ == "__main__":
    main()

# from collections import deque
# import sys
# input = sys.stdin.readline

# dx = [-1, 0 , 1, 0]
# dy = [0, -1, 0, 1]

# def bfs(q):
#     while q:
#         now_x, now_y, t = q.popleft()
#         for i in range(4):
#             nx = now_x + dx[i]
#             ny = now_y + dy[i]
#             if 0 <= nx < n and 0 <= ny < n and birus_arr[nx][ny] == 0:
#                 birus_arr[nx][ny] = t

# def main():
#     global birus_arr, q, n
#     n, k = map(int, input().split())
#     birus_arr = []
#     for _ in range(n):
#         birus_arr.append(list(map(int, input().split())))
#     s, x, y = map(int, input().split())

#     q = deque()
    
#     for _ in range(s):
#         for t in range(1, k + 1):
#             for i in range(n):
#                 for j in range(n):
#                     if birus_arr[i][j] == t:
#                         q.append((i, j, t))
#         bfs(q)
#     print(birus_arr[x - 1][y - 1])

# if __name__ == "__main__":
#     main()