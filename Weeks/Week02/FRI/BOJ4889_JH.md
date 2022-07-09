## 백준 4889번 안정적인 문자열 (실버 1)
### 문제링크
- https://www.acmicpc.net/problem/4889

### 알고리즘
1. 입력받은 문자열을 쪼개서 문자 배열 `chars`로 변환한다.
2. i번째 괄호 `chars[i]`의 값이 '{'라면 스택에 푸시한다.
3. `chars[i]`의 값이 '}'라면 스택의 맨 위 값이 '{'인지 확인해서 맞으면 스택에 pop 연산을 수행한다.
4. 스택의 맨 위 값이 '{'이 아니라면 스택에 `chars[i]`를 푸시한다.
5. 위의 과정을 `chars`의 모든 문자에 대해서 반복한다.
6. 반복문을 탈출한 후에 스택에서 꺼낸 값들이 '{'와 '{' 또는 '}'와 '}'면 한 번만 바꿔주면 되므로 `cnt`를 1증가시킨다.
7. 만약에 스택에서 꺼낸 값들이 '}'와 '{'면 두 번 바꿔줘야하므로 `cnt`를 2증가시킨다.
8. 위의 과정을 스택이 빌 때까지 반복한 후에 `list`에 `cnt`를 추가한다.
9. 각각의 테스트케이스에 대해서 위의 과정을 수행한 후에 테스트케이스 순서대로 `list`에서 값을 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ4889 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            List<Integer> list = new ArrayList<>();
            Stack<Character> s = new Stack<>();
            while(true) {
                char[] chars = br.readLine().toCharArray();
                if(chars[0]=='-') {
                    for(int i=1; i<=list.size(); i++)
                        bw.write(i+". "+list.get(i-1)+"\n");
                    bw.close();
                    return;
                }
                for(int i=0; i<chars.length; i++) {
                    if(chars[i]=='{') s.push(chars[i]);
                    else {
                        if(s.isEmpty()) s.push(chars[i]);
                        else {
                            if(s.peek()=='{') s.pop();
                            else s.push(chars[i]);
                        }
                    }
                }
                int cnt = 0;
                while(!s.isEmpty()) {
                    char a = s.pop();
                    char b = s.pop();
                    if(a=='{' && b=='{') cnt++;
                    else if(a=='}' && b=='}') cnt++;
                    else cnt += 2;
                }
                list.add(cnt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```