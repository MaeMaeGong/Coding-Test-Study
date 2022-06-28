## 백준 2667번 단지번호붙이기 (실버 1)
### 문제링크
- https://www.acmicpc.net/problem/2667

### 알고리즘
1. 값이 1이고 방문하지 않은 각각의 위치에 대해서 방문처리해준 후에 DFS를 시작하고 `types`를 1 증가시킨다.
2. DFS를 재귀적으로 수행할 때마다 `cnt`를 1씩 증가시키고, 재귀문을 빠져나오면 `answer`에 `cnt` 값을 추가한다.
3. `cnt`를 재사용하기 때문에 `cnt`를 0으로 초기화해주고, 위의 과정을 모든 위치에 대해서 반복한다.
4. `answer`를 오름차순으로 정렬해준 후에 `types`와 함께 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2667 {
    static int N, cnt;
    static int[][] grid;
    static boolean[][] visited;
    static List<Integer> answer;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static boolean check(int nx, int ny) {
        return nx>=0 && nx<N && ny>=0 && ny<N && grid[nx][ny]==1 && !visited[nx][ny];
    }
    static void dfs(int x, int y, int depth) {
        cnt++;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(check(nx, ny)) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth+1);
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            grid = new int[N][N];
            visited = new boolean[N][N];

            answer = new ArrayList<>();

            for(int i=0; i<N; i++) {
                String[] str = br.readLine().split("");
                for(int j=0; j<N; j++) {
                    grid[i][j] = Integer.parseInt(str[j]);
                }
            }

            int types = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(grid[i][j]==1 && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j, 1);
                        answer.add(cnt);
                        cnt = 0;
                        types++;
                    }
                }
            }

            Collections.sort(answer);
            bw.write(types+"\n");
            for(int item : answer)
                bw.write(item+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```