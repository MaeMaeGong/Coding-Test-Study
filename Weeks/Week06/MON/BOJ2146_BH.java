import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2146_BH {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Node> queue = new LinkedList<>();
    static Queue<Distance> answer = new LinkedList<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int num = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 구별
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    makeNum(i, j, num);
                    num++;
                    queue.clear();
                }
            }
        }
        // 방문 여부 초기화
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    bfs(i, j, map[i][j], 0);
                    visited = new boolean[N][N];
                    answer.clear();
                }
            }
        }
        System.out.println(min);
    }

    public static void makeNum(int r, int c, int num) {
        map[r][c] = num;
        queue.add(new Node(r, c));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = node.x + dr[i];
                int nc = node.y + dc[i];

                if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                    if (map[nr][nc] == 1 && !visited[nr][nc]) {
                        map[nr][nc] = num;
                        visited[nr][nc] = true;
                        queue.add(new Node(nr, nc));
                    }
                }
            }
        }
    }

    public static void bfs(int r, int c, int num, int count) {
        answer.add(new Distance(r, c, count));
        visited[r][c] = true;

        while (!answer.isEmpty()) {
            Distance node = answer.poll();

            for (int i = 0; i < 4; i++) {
                int nr = node.x + dr[i];
                int nc = node.y + dc[i];
                if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                    if (map[nr][nc] != num && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        if (map[nr][nc] != 0 && map[nr][nc] != num) {
                            min = Math.min(min, node.cnt);
                            return;
                        } else {
                            answer.add(new Distance(nr, nc, node.cnt + 1));
                        }
                    }
                }
            }
        }
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Distance {
        int x, y, cnt;

        public Distance(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
