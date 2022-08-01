import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ26234_BH {

    static int[][] country;
    static boolean[][] visited;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    static int N, L, R;
    static int sum = 0;
    static int cnt = 0;
    static int count = 0;
    static int circle = 0;
    static int k = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        country = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    if (country[a][b] != 0 && !visited[a][b]) {
                        sum += country[a][b];
                        cnt++;
                        dfs(a, b, country[a][b]);

                        if (count != 1) {
                            move();
                            sum = 0;
                            cnt = 0;
                        } else if (count == 1) {
                            visited[a][b] = false;
                            sum -= country[a][b];
                            cnt--;
                        }

                        count = 0;
                    }
                }
            }
            // move();
            System.out.println();
            for (int[] s : country) {
                for (int ss : s) {
                    System.out.print(ss + " ");
                }
                System.out.println();
            }
            System.out.println();
            if (k == 0) {
                break;
            }

            if (cnt > 0) {
                circle++;
                sum = 0;
                cnt = 0;
                k = 0;
                visited = new boolean[N][N];
            }
        }

        System.out.println(circle);

    }

    public static void dfs(int r, int c, int ncountry) {
        count++;
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                if (L <= Math.abs(ncountry - country[nr][nc]) && Math.abs(ncountry - country[nr][nc]) <= R
                        && !visited[nr][nc]) {
                    sum += country[nr][nc];
                    visited[nr][nc] = true;
                    dfs(nr, nc, country[nr][nc]);
                    cnt++;
                }
            }
        }
    }

    public static void move() {
        k++;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == true) {
                    country[i][j] = Math.round(sum / cnt);
                }
            }
        }
    }
}