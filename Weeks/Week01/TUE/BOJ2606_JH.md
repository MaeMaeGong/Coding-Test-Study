## 백준 2606번 바이러스 (실버 3)
### 문제링크
- https://www.acmicpc.net/problem/2606

### 알고리즘
1. 1번 컴퓨터에서 시작하므로 방문했음으로 처리한 후에 1번에 대해서 DFS를 수행한다.
2. DFS 이후에 `visited` 배열에서 값이 `true`인 원소의 개수만큼 `answer`를 1 증가시킨다.
3. 감염된 컴퓨터의 개수에 대해서 묻고 있으므로 `answer`의 값이 1이상이면 `answer`에서 1을 빼준 후에 출력한다.

### 소스코드
```java
package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2606 {
    static int N, M;
    static boolean[] visited;
    static List<List<Integer>> list;
    static void dfs(int start) {
        for(int i=0; i<list.get(start).size(); i++) {
            int adj = list.get(start).get(i);
            if(!visited[adj]) {
                visited[adj] = true;
                dfs(adj);
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            visited = new boolean[N+1];

            list = new ArrayList<>();
            for(int i=0; i<=N; i++) {
                list.add(new ArrayList<>());
            }

            for(int i=0; i<M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }

            visited[1] = true;
            dfs(1);

            int answer = 0;
            for(boolean item : visited)
                if(item) answer++;
            if(answer>0) answer--;
            bw.write(answer+"\n");
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
```