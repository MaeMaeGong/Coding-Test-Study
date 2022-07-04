from pydoc import visiblename
import sys
input = sys.stdin.readline
from collections import deque


def main():
    a, b = map(int, input().split())
    q = deque()
    q.append((a, 1))
    while q:
        now, time = q.popleft()
        if now == b:
            print(time)
            return
        for i in (now * 2, int(str(now) + '1')):
            if i <= b:
                q.append((i, time + 1))
    print(-1)

if __name__ == "__main__":
    main()
