## 백준 1935번 후위 표기식2 (실버 3)
### 문제링크
- https://www.acmicpc.net/problem/1935

### 알고리즘
1. 알파벳에 해당하는 숫자를 입력받아야 하므로`nums` 배열의 크기를 `N`으로 초기화한다.
2. 후위 표기식을 `char` 배열 형태로 변환한 후에 `nums` 배열에 숫자를 순서대로 입력받아서 대입한다.
3. `item`이 알파벳이라면 해당 알파벳에 대응하는 숫자를 `String`으로 형변환해서 스택에 푸시한다.
4. `item`이 연산자라면 스택의 맨 위에서부터 원소를 2개 뽑아서 연산자에 해당하는 연산을 수행하고, 그 결과를 스택에 푸시한다.
5. 위의 과정을 `chars`의 모든 원소에 대해서 반복한 후에 스택에서 팝한 결과를 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.*;

public class BOJ1935 {
    static int N;
    static Stack<String> s;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            char[] chars = br.readLine().toCharArray();

            int[] nums = new int[N];
            for(int i=0; i<N; i++) {
                nums[i] = Integer.parseInt(br.readLine());
            }

            s = new Stack<>();
            for (char item : chars) {
                if (item != '+' && item != '-' && item != '*' && item != '/') {
                    s.push(String.valueOf(nums[item - 65]));
                }
                else {
                    double a = Double.parseDouble(s.pop());
                    double b = Double.parseDouble(s.pop());
                    switch (item) {
                        case '+':
                            s.push(String.format("%.2f", b + a));
                            break;
                        case '-':
                            s.push(String.format("%.2f", b - a));
                            break;
                        case '*':
                            s.push(String.format("%.2f", b * a));
                            break;
                        case '/':
                            s.push(String.format("%.2f", b / a));
                            break;
                    }
                }
            }

            bw.write(s.pop()+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```