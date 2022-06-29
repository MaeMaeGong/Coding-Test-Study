## dp 풀기
from collections import deque
import sys
input = sys.stdin.readline

def main():
    global miro_arr, n, visited
    n = int(input())
    miro_arr = list(map(int, input().split()))
    visited = [n+1 for _ in range(n)]
    visited[0] = 0
    for i in range(n):
        for j in range(1, miro_arr[i] + 1):
            if i + j >= n:
                break
            visited[i + j] = min(visited[i + j], visited[i] + 1)
    print(visited[n-1] if visited[n-1] != n+1 else -1)

if __name__ == "__main__":
    main()


## bfs 풀기
from collections import deque
import sys
input = sys.stdin.readline

def bfs(s):
    global miro_arr, n, visited
    q = deque()
    q.append((s, 0))
    while q:
        now, time = q.popleft()
        if now == n - 1:
            print(time)
            return
        for i in range(1, miro_arr[now] + 1):
            nx = now + i
            if nx < n and miro_arr[nx] > 0 and visited[nx] == 0:
                visited[nx] = 1
                q.append((nx, time + 1))
    print(-1)

def main():
    global miro_arr, n, visited
    n = int(input())
    miro_arr = list(map(int, input().split()))
    visited = [0 for _ in range(n)]
    bfs(0)

if __name__ == "__main__":
    main()