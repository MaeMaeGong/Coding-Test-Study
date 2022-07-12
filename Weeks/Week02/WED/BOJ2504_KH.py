import sys
input = sys.stdin.readline

def main():
    arr = input().rstrip()
    temp = []
    temp.append(arr[0])
    for i in arr[1:]:
        if i == ")":
            temp_int = 0
            while temp:
                top = temp.pop()
                if top == "(":
                    if temp_int == 0:
                        temp.append(2)
                    else:
                        temp.append(2 * temp_int)
                    break
                elif type(top) == int:
                    temp_int += int(top)
                else:
                    print(0)
                    return
        elif i == "]":
            temp_int = 0
            while temp:
                top = temp.pop()
                if top == "[":
                    if temp_int == 0:
                        temp.append(3)
                    else:
                        temp.append(3 * temp_int)
                    break
                elif type(top) == int:
                    temp_int += top
                else:
                    print(0)
                    return
        else:
            temp.append(i)
    answer = 0
    for i in temp:
        if type(i) == str:
            print(0)
            return
        else:
            answer += i
    print(answer)            

if __name__ == "__main__":
    main()