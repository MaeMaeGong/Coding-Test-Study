## 백준 2504번 괄호의 값 (실버 1)
### 문제링크
- https://www.acmicpc.net/problem/2504

### 알고리즘
1. 곱한 값을 활용해주기 위해서 `temp`를 1로 초기화한다.
2. 입력받은 괄호가 `(` 또는 `)`라면 스택에 푸쉬하고 `temp`에 2 또는 3을 곱한다.
3. 입력받은 괄호가 `)`이고 스택이 비었거나 스택의 맨 윗값이 `[`라면 `answer`에 0을 대입하고 반복문을 탈출한다.
4. 스택이 비어있지 않고 스택의 맨 윗값이 `(`라면 `temp`를 2로 나눠주고 스택의 맨 윗값을 제거한다.
5. 이전 괄호가 `(`라면 `temp`를 2로 나눠주기 전에 `answer`에 `temp` 값을 더해준다.
6. 입력받은 괄호가 `]`이고 스택이 비었거나 스택의 맨 윗값이 `(`라면 `answer`에 0을 대입하고 반복문을 탈출한다.
7. 스택이 비어있지 않고 스택의 맨 윗값이 `[`라면 `temp`를 3으로 나눠주고 스택의 맨 윗값을 제거한다.
8. 이전 괄호가 `[`라면 `temp`를 3으로 나눠주기 전에 `answer`에 `temp` 값을 더해준다.
9. 위의 과정을 배열에 포함된 모든 괄호에 대해서 반복한다.
10. 예외처리를 위해 스택이 비어있는지 확인해서 비어있으면 0을 출력하고 그렇지 않으면 `answer`를 출력한다.


### 소스코드
```java
import java.io.*;
import java.util.Stack;

public class BOJ2504 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            Stack<Character> s = new Stack<>();

            int temp = 1;
            int answer = 0;
            char[] chars = br.readLine().toCharArray();
            for(int i=0; i<chars.length; i++) {
                if(chars[i]=='(') {
                    s.push(chars[i]);
                    temp *= 2;
                }
                else if(chars[i]=='[') {
                    s.push(chars[i]);
                    temp *= 3;
                }
                else if(chars[i]==')') {
                    if(s.isEmpty() || s.peek()=='[') {
                        answer = 0;
                        break;
                    }
                    // 짝 괄호가 아닌 괄호가 더해지는 것을 방지
                    if(chars[i-1]=='(') answer += temp;
                    temp /= 2;
                    s.pop();
                }
                else if(chars[i]==']') {
                    if(s.isEmpty() || s.peek()=='(') {
                        answer = 0;
                        break;
                    }
                    // 짝 괄호가 아닌 괄호가 더해지는 것을 방지
                    if(chars[i-1]=='[') answer += temp;
                    temp /= 3;
                    s.pop();
                }
            }

            if(!s.isEmpty()) bw.write(0+"\n");
            else bw.write(answer+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```