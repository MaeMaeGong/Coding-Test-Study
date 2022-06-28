import sys
input = sys.stdin.readline

def dfs(R):
    global answer, arr, visited
    for i in arr[R]:
        if i not in visited:
            visited.append(i)
            dfs(i)


def main():
    global arr, answer, visited
    n = int(input())
    m = int(input())
    arr = [[] for _ in range(n + 1)]
    answer = 0
    for _ in range(m):
        i, j = map(int, input().split())
        arr[i].append(j)
        arr[j].append(i)
    visited = []
    dfs(1)
    print(len(visited) - 1)

if __name__ == "__main__":
    main()