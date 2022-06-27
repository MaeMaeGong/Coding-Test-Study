from collections import deque
import sys
input = sys.stdin.readline

def dfs(R):
    ch[R] = True
    print(R, end=' ')
    for i in range(1, n + 1):
        if arr[R][i] == 1 and not ch[i]:
            dfs(i)

def bfs(R):
    q = deque()
    ch[R] = True
    q.append(R)
    while(q):
        start = q.popleft()
        print(start, end=' ')
        for i in range(1, n + 1):
            if arr[start][i] == 1 and not ch[i]:
                ch[i] = True
                q.append(i)

def main():
    global ch, arr, n
    n, m, s = map(int, input().split())
    arr = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
    for _ in range(m):
        i, j = map(int, input().split())
        arr[i][j] = 1
        arr[j][i] = 1
    ch = [False for _ in range(n + 1)]
    dfs(s)
    print()
    ch = [False for _ in range(n + 1)]
    bfs(s)

if __name__ == '__main__':
    main()
