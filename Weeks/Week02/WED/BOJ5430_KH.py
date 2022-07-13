from collections import deque
import sys
input = sys.stdin.readline

def main():
    t = int(input())
    result = []
    for _ in range(t):
        p = input().rstrip()
        n = int(input())
        temp = input().rstrip()
        q = deque()
        if n > 0:
            q = deque(temp[1:-1].split(','))
            cnt = 0
            cnt_d = 0
            for i in p[:]:
                if i == "R":
                    cnt += 1
                elif i == "D":
                    if len(q) > 0:
                        if cnt % 2 == 1:
                            q.pop()
                        else:
                            q.popleft()
                    else:
                        result.append("error")
                        break
            else:
                if cnt % 2 == 1:
                    q.reverse()
                temp_str = []
                if len(q) == 0:
                    result.append("[]")
                else:
                    temp_str.append("[")
                    for i in q:
                        temp_str.append(str(i))
                        temp_str.append(",")
                    temp_str.pop()
                    temp_str.append("]")
                    result.append("".join(temp_str))
        else:
            if "D" in p[:]:
                result.append("error")
            else:
                result.append("[]")

    for i in result:
        print(i)
        


if __name__ == "__main__":
    main()