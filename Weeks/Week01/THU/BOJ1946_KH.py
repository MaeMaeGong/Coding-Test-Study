from collections import deque
import sys
input = sys.stdin.readline

def main():
    t = int(input())
    result = []
    for _ in range(t):
        cnt = 1
        n = int(input())
        grade_arr = [list(map(int, input().split())) for _ in range(n)]
        grade_arr.sort(key=lambda x:x[0])
        grade2 = grade_arr[0][1]
        for i in range(len(grade_arr)):
            if grade_arr[i][1] < grade2:
                grade2 = grade_arr[i][1]
                cnt += 1
        result.append(cnt)
    for i in result:
        print(i)
    
if __name__ == "__main__":
    main()