## 백준 1182번 부분수열의 합 (실버 2)
### 문제링크
- https://www.acmicpc.net/problem/1182

### 알고리즘
1. 수열에서 임의의 원소를 선택해서 모두 더한 값이 S가 되도록 만드는 경우의 수를 구하는 문제이다.
2. `i`번째 원소를 시작으로 재귀와 백트래킹을 통해 만들 수 있는 모든 `sum`을 구하고 `S`와 일치하는지 비교해서 경우의 수를 구해준다.

### 소스코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ1182 {
    static int N, S, answer;
    static int[] arr;
    static void recur(int idx, int sum) {
        if(sum==S) answer++;
        for(int i=idx+1; i<N; i++) {
            sum += arr[i];
            recur(i, sum);
            sum -= arr[i];
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<N; i++) {
                recur(i, arr[i]);
            }

            bw.write(answer+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```