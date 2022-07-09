## 백준 2841번 안정적인 문자열 (실버 1)
### 문제링크
- https://www.acmicpc.net/problem/2841

### 알고리즘
1. 외계인이 가진 6개의 손가락을 각각 스택으로 보고, 스택을 원소로 갖는 리스트를 선언한다.
2. 문자열을 입력받으면 편의상 스택을 가리키는 문자를 `a`, 프랫을 가리키는 문자을 `b`로 선언한다.
3. 만약에 스택 `a`가 비어있으면 `a`에 `b`를 푸시하고 `cnt`를 1증가시킨다.
4. `a`가 비어있지 않으면 `a`의 맨 위 값이 `b`보다 큰지 확인해서 `a`에서 pop 연산을 수행하고 `cnt`를 1증가시킨다.
5. 위의 과정을 스택이 비어있지 않고 맨 위 값이 `b`보다 클 때까지 반복한다.
6. `while`문을 탈출하면 스택을 확인해서 비어있거나 스택의 맨 위 값이 `b`보다 작으면 `a`에 `b`를 푸시하고 `cnt`를 1증가시킨다.
7. 위의 과정을 입력받은 문자열의 개수 `N`만큼 수행하고 `cnt`를 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2841 {
    static int N, P;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            List<Stack<Integer>> list = new ArrayList<>();
            for(int i=0; i<=6; i++) {
                list.add(new Stack<>());
            }

            int cnt = 0;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(list.get(a).isEmpty()) {
                    list.get(a).push(b);
                    cnt++;
                }
                else {
                    while(!list.get(a).isEmpty() && list.get(a).peek()>b) {
                        list.get(a).pop();
                        cnt++;
                    }
                    if(list.get(a).isEmpty() || !list.get(a).isEmpty() && list.get(a).peek()<b) {
                        list.get(a).push(b);
                        cnt++;
                    }
                }
            }

            bw.write(cnt+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```