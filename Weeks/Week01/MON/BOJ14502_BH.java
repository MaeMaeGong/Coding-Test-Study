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
    static int[][] copy_virus;

    static int cnt; // 벽 세운 갯수
    static int x, y; // 바이러스 위치

    static Queue<Infection> queue = new LinkedList<Infection>();

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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virus[i][j] == 2) {
                    queue.add(new Infection(i, j));
                }
            }
        }

        make_wall();

        System.out.println();
        for (int[] s : virus) {
            for (int ss : s) {
                System.out.print(ss + " ");
            }
            System.out.println();
        }
    }

    public static void make_wall() {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virus[i][j] == 0) {
                    virus[i][j] = 1;
                    cnt++;
                    make_wall();
                    virus[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {

    }

    public class Infection {
        int x, y;

        public Infection(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}