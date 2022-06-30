import sys
input = sys.stdin.readline

def main():
    arr = input()
    num = []
    num_str = ""

    for i in arr:
        if i == '-':
            num.append(num_str)
            num_str = ''
        else:
            num_str += i
    num.append(num_str)
    temp = ""
    temp_num = 0

    for i in range(len(num)):
        temp = "" 
        temp_num = 0
        for j in num[i]:
            if j == '+':
                temp_num += int(temp)
                temp = "" 
            else:
                temp += j
        temp_num += int(temp)
        num[i] = temp_num
        
    answer = num[0]

    if len(num) > 1:
        for i in range(1, len(num)):
            answer -= int(num[i])
    print(answer)

if __name__ == "__main__":
    main()