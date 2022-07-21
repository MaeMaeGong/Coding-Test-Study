## 백준 1138번 한 줄로 서기 (실버 2)
### 문제링크
- https://www.acmicpc.net/problem/1138

### 알고리즘
1. 왼쪽에 자기보다 키가 큰 사람이 몇 명이 있었는지에 대한 데이터를 기반으로 줄을 세우는 문제이다.
2. 데이터는 키가 1인 사람부터 N인 사람의 순서대로 주어지는데 키가 클수록 데이터의 값이 작아진다.
3. 따라서 키가 큰 사람순으로 왼쪽에 자기보다 키가 큰 사람이 몇 명이 있었는지에 대한 데이터의 크기만큼 줄 선 사람을 건너뛰어서 줄을 세우면 된다.

### 소스코드
```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1138 {
    static int N;
    static int[] arr;
    static List<Integer> list;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];

            list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            list.add(N);
            for(int i=N-1; i>=1; i--) {
                list.add(arr[i], i);
            }

            for(int item : list)
                bw.write(item+" ");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```