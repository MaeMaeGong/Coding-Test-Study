from collections import deque
import sys
input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def dfs(x, y, temp):
    global num_arr, answer
    if len(temp) == 6:
        answer.add(int(''.join(temp)))
        return
    else:
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < 5 and 0 <= ny < 5:
                temp.append(str(num_arr[nx][ny]))
                dfs(nx, ny, temp)
                temp.pop()

def main():
    global num_arr, answer
    num_arr = [list(map(int, input().split())) for _ in range(5)]
    answer = set()
    for i in range(5):
        for j in range(5):
            dfs(i , j, [str(num_arr[i][j])])
    print(len(answer))


if __name__ == "__main__":
    main()

# def bfs(i, j):
#     global num_arr, answer
#     q = deque()
#     q.append((i, j, [str(num_arr[i][j])]))
#     while q:
#         x, y, temp  = q.popleft()
#         if len(temp) == 6:
#             answer.add(int(''.join(temp)))
#             print(answer)
#         else:
#             for i in range(4):
#                 nx = x + dx[i]
#                 ny = y + dy[i]
#                 if 0 <= nx < 5 and 0 <= ny < 5:
#                     temp.append(str(num_arr[nx][ny]))
#                     q.append((nx, ny, temp))

# def main():
#     global num_arr, answer
#     num_arr = [list(map(int, input().split())) for _ in range(5)]
#     answer = set()
#     for i in range(5):
#         for j in range(5):
#             bfs(i , j)
#     print(len(answer))


# if __name__ == "__main__":
#     main()