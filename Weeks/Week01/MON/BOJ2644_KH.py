from collections import deque
import sys
input = sys.stdin.readline

def bfs(start):
    lev = 0
    q = deque()
    q.append(start)
    ch[start] = 1
    while(q):
        now = q.popleft()
        for i in arr[now]:
            if ch[i] != 1:
                result[i] = result[now] + 1
                q.append(i)
                ch[i] = 1

def main():
    global n, arr, ch, result
    n = int(input())
    s, e = map(int, input().split())
    m = int(input())
    arr = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
    for _ in range(m):
        i, j = map(int, input().split())
        arr[i].append(j)
        arr[j].append(i)

    ch = [0 for _ in range(n + 1)]
    result = [0 for _ in range(n + 1)]
    bfs(s)
    if result[e] == 0:
        print(-1)
    else:
        print(result[e])

if __name__ == '__main__':
    main()