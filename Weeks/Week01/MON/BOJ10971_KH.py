import sys
input = sys.stdin.readline
answer = sys.maxsize


def dfs(start, next, value, visited):
    global answer, n

    if len(visited) == n:
        if w[next][start] != 0:
            answer = min(answer, value + w[next][start])
        return
    for i in range(n):
        if w[next][i] != 0 and i != start and i not in visited and value < answer:
            visited.append(i)
            dfs(start, i, value + w[next][i], visited)
            visited.pop()

def main():
    global answer, visited, w, n
    n = int(input())
    w = [list(map(int, input().split())) for _ in range(n)]
    for i in range(n):
        dfs(i, i, 0, [i])

    print(answer)

if __name__ == '__main__':
    main()
