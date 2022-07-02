
//2차원 배열 dfs로 문제를 해결함
//단지의 총 갯수는 main에서 dfs가 호출되는 숫자이다.
//각 단지에서의 집 수는 dfs함수 내부에서 재귀가 일어나는 횟수이다.
//상,하,좌,우 모두를 탐색할 수 있도록 전역변수로 dr, dc 배열을 선언하였다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2667_BH {
    static int N;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int[][] village;
    static boolean[][] visited;
    static int count = 0;
    static int cnt = 0;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        village = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            String k = br.readLine();
            for (int j = 0; j < N; j++) {
                String kk = k.substring(j, j + 1);
                village[i][j] = Integer.parseInt(kk);
            }
        }

        for (int a = 0; a < N; a++) {
            for (int b = 0; b < N; b++) {
                if (!visited[a][b] && village[a][b] == 1) {
                    dfs(a, b);
                    count++;
                    cnt++;
                    list.add(cnt);
                    cnt = 0;
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for (int s : list) {
            System.out.println(s);
        }
    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                if (village[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    dfs(nr, nc);
                    cnt++;
                }
            }
        }
    }
}
