## 백준 2529번 부등호 (실버 2)
### 문제링크
- https://www.acmicpc.net/problem/2529

### 알고리즘
1. 부등호 사이에 숫자를 넣었을 때 만족하는 최대값과 최소값을 구하는 문제이다.
2. 따라서 0부터 9까지 숫자를 하나씩 넣어보고 백트래킹하면서 부등호의 결과들을 모두 만족하면 최대값과 최소값을 갱신해주면 된다.

### 소스코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ2529 {
    static int N;
    static String min, max;
    static long[] ret;
    static char[] arr;
    static boolean[] visited;
    static void func(int depth) {
        if(depth==N) {
            StringBuilder str = new StringBuilder();
            for(long item : ret) {
                str.append(item);
            }
            if(Long.parseLong(max) < Long.parseLong(str.toString())) max = str.toString();
            if(Long.parseLong(min) > Long.parseLong(str.toString())) min = str.toString();
            return;
        }
        for(int i=0; i<10; i++) {
            if(!visited[i] && ( (arr[depth]=='>' && ret[depth]>i) || (arr[depth]=='<' && ret[depth]<i)) ) {
                ret[depth+1] = i;
                visited[i] = true;
                func(depth+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            arr = new char[N];
            ret = new long[N+1];
            visited = new boolean[10];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = st.nextToken().charAt(0);
            }

            max = "00000000000".substring(0, N+2);
            min = "99999999999".substring(0, N+2);
            for(int i=0; i<10; i++) {
                ret[0] = i;
                visited[i] = true;
                func(0);
                visited[i] = false;
            }

            bw.write(max+"\n");
            bw.write(min+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```