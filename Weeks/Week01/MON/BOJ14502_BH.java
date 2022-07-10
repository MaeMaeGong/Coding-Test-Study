import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502_BH {
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int n, m;
    static int[][] virus;
    static boolean[][] visited;
    static int answer = 0;

    static int cnt = 0; // 벽 세운 갯수

    static Queue<Infection> queue = new LinkedList<Infection>();
    static int[][] copy_virus;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        virus = new int[n][m];
        visited = new boolean[n][m];
        copy_virus = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                virus[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        make_wall(cnt);
        System.out.println(answer);
    }

    public static void make_wall(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virus[i][j] == 0) {
                    virus[i][j] = 1;
                    make_wall(cnt + 1);
                    virus[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {

        queue.clear();

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                copy_virus[a][b] = virus[a][b];
            }
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (virus[a][b] == 2) {
                    queue.add(new Infection(a, b));
                }
            }
        }

        while (!queue.isEmpty()) {
            Infection infect = queue.poll();
            int r = infect.sx;
            int c = infect.sy;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if (copy_virus[nr][nc] == 0) {
                        copy_virus[nr][nc] = 2;
                        queue.add(new Infection(nr, nc));
                    }
                }
            }
        }

        virus_count();
    }

    public static void virus_count() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy_virus[i][j] == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
    }

    public static class Infection {
        int sx, sy;

        public Infection(int sx, int sy) {
            this.sx = sx;
            this.sy = sy;
        }
    }
}