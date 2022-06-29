import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ4963_BH {

    static int[] dr = { 1, 1, 1, 0, 0, -1, -1, -1 };
    static int[] dc = { 1, 0, -1, 1, -1, 1, 0, -1 };

    static int[][] island;
    static boolean[][] visited;

    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            island = new int[y][x];
            visited = new boolean[y][x];
            if (x == 0 && y == 0) {
                break;
            }

            for (int i = 0; i < y; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < x; j++) {
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int a = 0; a < y; a++) {
                for (int b = 0; b < x; b++) {
                    if (island[a][b] != 0 && !visited[a][b]) {
                        dfs(a, b, x, y);
                        cnt++;
                    }
                }
            }

            // visited = new boolean[x][y];
            bw.write(cnt + "\n");
            // System.out.println(cnt);
            cnt = 0;
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int r, int c, int w, int h) {
        visited[r][c] = true;

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < h && nc < w) {
                if (island[nr][nc] != 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    dfs(nr, nc, w, h);
                }
            }
        }
    }
}